package me.dri.restproject.mapper;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.List;

public class DozerMapper {

    private static Mapper mapper = new DozerBeanMapper();


    public static  <O, D>  D parseObj(O origin, Class<D> destination) {
        return mapper.map(origin, destination);
    }
    public static  <O, D> List<D> parseListObj(List<O> origin, Class<D> destination) {
        List<D> destinationObjs = new ArrayList<D>();
        for (O d : origin) {
            destinationObjs.add(mapper.map(d, destination));
        }
        return destinationObjs;
    }

}
