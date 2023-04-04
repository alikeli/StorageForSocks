
package com.project.storageforsocks.service;

import com.project.storageforsocks.dto.SocksDto;
import com.project.storageforsocks.entity.OperationEnum;
import com.project.storageforsocks.entity.Socks;
import com.project.storageforsocks.exception.SocksNotFoundException;
import com.project.storageforsocks.mapper.SocksMapper;
import com.project.storageforsocks.repository.SocksRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class SocksService {

    private final SocksRepository socksRepository;

    private final SocksMapper socksMapper;

    public SocksService(SocksRepository socksRepository, SocksMapper socksMapper) {
        this.socksRepository = socksRepository;
        this.socksMapper = socksMapper;
    }


    /**
     * Add socks to DB.
     * If DB contains entry with the same color and cotton part, then its amount will be increased amount.
     *
     * @param socksDto {@link SocksDto} instance from user's request.
     */

    @Transactional
    public void addSocks(SocksDto socksDto) {
        log.info("Method 'addSocks' had been started");
        Optional<Socks> socks = socksRepository
                .findByColorAndCottonPart(socksDto.getColor(), socksDto.getCottonPart());
        Socks newSocks;
        if (socks.isPresent()) {
            newSocks = socks.get();
            newSocks.setQuantity(newSocks.getQuantity() + socksDto.getQuantity());
        } else {
            newSocks = socksMapper.toEntity(socksDto);
        }
        socksRepository.save(newSocks);
    }

    /**
     * Remove the required amount of socks from DB.
     *
     * @param socksDto {@link Socks} instance from user's request.
     * @throws SocksNotFoundException if socks are not present
     */

    public void removeSocks(SocksDto socksDto) {
        log.debug("method removeSocks had been started");
        Socks socks = socksRepository.findByColorAndCottonPart(socksDto.getColor(), socksDto.getCottonPart()).orElseThrow();
        if (socks.getQuantity() < socksDto.getQuantity()) {
            log.warn("Socks not found");
            throw new SocksNotFoundException();
        }
        socks.setQuantity(socks.getQuantity() - socksDto.getQuantity());
        socksRepository.save(socks);
    }


    /**
     * Get the number of socks available in stock based on color,
     * cotton part and comparison operators.
     *
     * @param color      name of the color
     * @param operation  comparison operator
     * @param cottonPart desired amount of cotton
     * @return numbers of socks matching the required params or nothing
     */

    public Integer getAmountOfSocks(String color, Integer cottonPart, OperationEnum operation) {
        log.debug("method getAmountOfSocks had been started");
        List<Socks> socks = new ArrayList<>();

        switch (operation) {
            case EQUAL: {
                socks = socksRepository.findAllByColorAndCottonPartEquals(color, cottonPart);
                break;
            }
            case LESSTHAN: {
                socks = socksRepository.findAllByColorAndCottonPartLessThan(color, cottonPart);
                break;
            }
            case MORETHAN: {
                socks = socksRepository.findAllByColorAndCottonPartGreaterThan(color, cottonPart);
                break;
            }

        }
        log.debug("method getAmountOfSocks had been ended");
        return socks.stream().map(Socks::getQuantity).reduce(0, Integer::sum);
    }


}




