package com.example.springBoot.service.sheetMaterial;

import com.example.springBoot.model.material.SheetMaterial;
import com.example.springBoot.repository.sheetMaterial.SheetMaterialRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommonSheetMaterialServiceImpl extends SheetMaterialServiceImpl<SheetMaterial, SheetMaterialRepository> {
    public CommonSheetMaterialServiceImpl(SheetMaterialRepository repository) {
        super(repository);
    }

    public boolean findAllByProductSchema(List<SheetMaterial> schema) {

        boolean b = true;

        for (SheetMaterial material : schema) {
            SheetMaterial sheetMaterial = findByMaterial(material);

            if (sheetMaterial.getMaterialsCount() < material.getMaterialsCount()) {
                b = false;
            }

            if (sheetMaterial == null) {
                b = false;
            }
        }

        return b;
    }

    public void deleteAllByProductSchema(List<SheetMaterial> schema) {
        if (findAllByProductSchema(schema)) {
            for (SheetMaterial material : schema) {

                SheetMaterial newMaterial = findByMaterial(material);

                int materialsCount = newMaterial.getMaterialsCount() - material.getMaterialsCount();

                newMaterial.setMaterialsCount(materialsCount);

                update(newMaterial);
            }
        }
    }

    public void addAllByProductSchema(List<SheetMaterial> schema) {
        if (findAllByProductSchema(schema)) {
            for (SheetMaterial material : schema) {

                SheetMaterial newMaterial = findByMaterial(material);

                int materialsCount = material.getMaterialsCount() + newMaterial.getMaterialsCount();

                newMaterial.setMaterialsCount(materialsCount);

                update(newMaterial);
            }
        }
    }
}

/*    private final MdfServiceImpl mdfService;
    private final ChipboardServiceImpl chipboardService;
    private final WoodServiceImpl woodService;
    private final GlassServiceImpl glassService;*/

/*    private final SheetMaterialRepository sheetMaterialRepository;

    public CommonSheetMaterialServiceImpl(SheetMaterialRepository sheetMaterialRepository) {
        this.sheetMaterialRepository = sheetMaterialRepository;
    }*/

    /* public CommonSheetMaterialServiceImpl(MdfServiceImpl mdfService, ChipboardServiceImpl chipboardService, WoodServiceImpl woodService, GlassServiceImpl glassService, SheetMaterialRepository sheetMaterialRepository) {
        this.mdfService = mdfService;
        this.chipboardService = chipboardService;
        this.woodService = woodService;
        this.glassService = glassService;
        this.sheetMaterialRepository = sheetMaterialRepository;
    }

    @Override
    public void save(SheetMaterial newMaterial) {
        super.;

*//*        MaterialType type = newMaterial.getMaterialType();

        switch (type) {
            case MDF:
                mdfService.save((Mdf) newMaterial);
                break;
            case CHIPBOARD:
                chipboardService.save((Chipboard) newMaterial);
                break;
            case GLASS:
                glassService.save((Glass) newMaterial);
                break;
            case WOOD:
                woodService.save((Wood) newMaterial);
                break;
        }*//*
    }

    @Override
    public void update(SheetMaterial newMaterial) {
        MaterialType type = newMaterial.getMaterialType();
        switch (type) {
            case MDF:
                mdfService.update((Mdf) newMaterial);
                break;
            case CHIPBOARD:
                chipboardService.update((Chipboard) newMaterial);
        }
    }

    @Override
    public List<SheetMaterial> findAll() {
        return sheetMaterialRepository.findAll();
    }

    @Override
    public SheetMaterial findById(int id) {
        List<SheetMaterial> materials = findAll();
        SheetMaterial material = materials.stream()
                .filter(m -> m.getId() == id)
                .findFirst().orElse(null);
        return material;

    }

    @Override
    public SheetMaterial findByMaterial(SheetMaterial material) {

        MaterialType type = material.getMaterialType();
        switch (type) {
            case MDF:
                return mdfService.findByMaterial((Mdf) material);
            case CHIPBOARD:
                return chipboardService.findByMaterial((Chipboard) material);
            default:
                return null;
        }
    }

    @Override
    public void deleteById(int id) {

        SheetMaterial material = findById(id);

        MaterialType type = material.getMaterialType();
        switch (type) {
            case MDF:
                mdfService.deleteById(id);
                break;
            case CHIPBOARD:
                chipboardService.deleteById(id);
                break;

        }
    }

    public boolean findAllByProductSchema(List<SheetMaterial> schema) {

        for (SheetMaterial material : schema) {
            SheetMaterial sheetMaterial = findByMaterial(material);
            if (sheetMaterial == null) {
                return false;
            }
        }
        return true;
    }

    public void deleteAllByProductSchema(List<SheetMaterial> schema) {
        if (findAllByProductSchema(schema)) {
            for (SheetMaterial material : schema) {

                SheetMaterial newMaterial = findByMaterial(material);

                int materialsCount = newMaterial.getMaterialsCount() - material.getMaterialsCount();

                newMaterial.setMaterialsCount(materialsCount);

                update(newMaterial);
            }
        }
    }
    }
}*/
