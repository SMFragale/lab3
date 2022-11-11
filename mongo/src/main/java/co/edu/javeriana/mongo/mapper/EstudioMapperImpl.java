package co.edu.javeriana.mongo.mapper;

import co.edu.javeriana.domain.model.Estudio;
import co.edu.javeriana.mongo.document.EstudioDocument;
import org.modelmapper.ModelMapper;

public class EstudioMapperImpl implements EstudioMapper{
    private ModelMapper mapper;

    public EstudioMapperImpl() {
        mapper = new ModelMapper();
        mapper.typeMap(EstudioDocument.class, Estudio.class).addMappings(mapping -> {
            mapping.map(EstudioDocument::getUniver, Estudio::setUniversidad);
            mapping.map(EstudioDocument::getCc_per, Estudio::setPersona);
            mapping.map(EstudioDocument::getId_prof, Estudio::setProfesion);
            mapping.map(EstudioDocument::getFecha, Estudio::setFecha);
        });
    }

    @Override
    public Estudio fromDocumentToDomain(EstudioDocument document){
        return mapper.map(document, Estudio.class);
    }

    @Override
    public EstudioDocument fromDomainToDocument(Estudio domain){
        return mapper.map(domain, EstudioDocument.class);
    }
}
