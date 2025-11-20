package AutaZa.AutaZa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AutaZa.AutaZa.model.Color;
import AutaZa.AutaZa.repository.ColorRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ColorService {

    @Autowired
    private ColorRepository colorRepository;

    public List<Color> findAll() {
        return colorRepository.findAll();
    }

    public Color findById(Integer idColor) {
        return colorRepository.findById(idColor).orElse(null);
    }

    public Color save(Color color) {
        return colorRepository.save(color);
    }

    public Color partialUpdate(Color color) {
        Color existing = colorRepository.findById(color.getIdColor()).orElse(null);

        if (existing != null) {

            if (color.getNombre() != null)
                existing.setNombre(color.getNombre());

            if (color.getCodigoHex() != null)
                existing.setCodigoHex(color.getCodigoHex());

            return colorRepository.save(existing);
        }
        return null;
    }

    public void deleteById(Integer idColor){
        colorRepository.deleteById(idColor);
    }
}
