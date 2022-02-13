package enums;

public enum RegionalSenaiEnum {
    NORTE_NORDESTE(1, "Norte - Nordeste"),
    OESTE(2, "Oeste"),
    SUDESTE(3, "Sudeste"),
    CENTRO_NORTE(4, "Centro - Norte"),
    VALE_DO_ITAJAI(5, "Vale do Itajaí"),
    VALE_DO_ITAPOCU(6, "Vale do Itapocu"),
    LITORAL_SUL(7, "Litoral Sul"),
    ALTO_URUGUAI_CATARINENSE(8, "Alto Uruguai Catarinense"),
    VALE_DO_ITAJAI_MIRIM(9, "Vale do Itajaí Mirim"),
    CENTRO_OESTE(10, "Centro - Oeste"),
    PLANALTO_NORTE(11, "Planalto Norte"),
    FOZ_DO_RIO_ITAJAI(12, "Foz do Rio Itajaí"),
    SUL(13, "Sul"),
    SERRA_CATARINENSE(14, "Serra Catarinense"),
    EXTREMO_OESTE(15, "Extremo Oeste"),
    ALTO_VALE_DO_ITAJAI(16, "Alto Vale do Itajaí");


    private int id;
    private String descricao;

    RegionalSenaiEnum(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
}
