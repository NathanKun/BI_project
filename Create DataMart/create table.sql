DROP TABLE demandecommerciaux_dmc;
DROP TABLE demandepartenaire_dmp;
DROP TABLE demandefournisseur_dmf;
DROP TABLE demandegarant_dmg;
DROP TABLE commercial_cmc;
DROP TABLE fournisseur_fns;
DROP TABLE garant_grt;
DROP TABLE partenaire_ptn;
DROP TABLE date_dte;

CREATE TABLE commercial_cmc
(
cmc_id VARCHAR(50) CONSTRAINT commercial_cmc_cmc_id_pk PRIMARY KEY,
cmc_nom VARCHAR(50),
cmc_prenom VARCHAR(50)
);

CREATE TABLE fournisseur_fns
(
fns_id VARCHAR(50) CONSTRAINT fournisseur_fns_fns_id_pk PRIMARY KEY,
fns_nom VARCHAR(50),
fns_prenom VARCHAR(50),
fns_siret NUMBER(14)
);

CREATE TABLE garant_grt
(
grt_id VARCHAR(50) CONSTRAINT garant_grt_grt_id_pk PRIMARY KEY,
grt_nom VARCHAR(50),
grt_prenom VARCHAR(50),
grt_siret NUMBER(14),
grt_capitalsocial NUMBER(20)
);

CREATE TABLE date_dte
(
dte_id NUMBER(5) CONSTRAINT date_dte_dte_id_pk PRIMARY KEY,
dte_date DATE,
dte_year NUMBER(4),
dte_month NUMBER(2)
);

CREATE TABLE partenaire_ptn
(
ptn_id VARCHAR(50) CONSTRAINT partenaire_ptn_ptn_id_pk PRIMARY KEY,
ptn_nom VARCHAR(50),
ptn_prenom VARCHAR(50),
ptn_siret NUMBER(14),
ptn_capitalsocial NUMBER(20)
);

CREATE TABLE demandecommerciaux_dmc
(
    dmc_id VARCHAR(50) CONSTRAINT dmc_id_pk PRIMARY KEY,
    dmc_montant NUMBER(18,2),
    dmc_crd NUMBER(18,2),
    dmc_paid NUMBER(1,0),
    dmc_closed NUMBER(1,0),
    dmc_date NUMBER(5),
    dmc_cmc_id VARCHAR(50),
CONSTRAINT FK_dmc_date FOREIGN KEY (dmc_date) REFERENCES date_dte(dte_id),
CONSTRAINT FK_dmc_id FOREIGN KEY (dmc_cmc_id) REFERENCES commercial_cmc(cmc_id)
);

CREATE TABLE demandepartenaire_dmp
(
    dmp_id VARCHAR(50) CONSTRAINT dmp_id_pk PRIMARY KEY,
    dmp_montant NUMBER(18,2),
    dmp_crd NUMBER(18,2),
    dmp_paid NUMBER(1,0),
    dmp_closed NUMBER(1,0),
    dmp_date NUMBER(5),
    dmp_ptn_id VARCHAR(50),
CONSTRAINT FK_dmp_date FOREIGN KEY (dmp_date) REFERENCES date_dte(dte_id),
CONSTRAINT FK_dmp_id FOREIGN KEY (dmp_ptn_id) REFERENCES partenaire_ptn(ptn_id)
);

CREATE TABLE demandefournisseur_dmf
(
    dmf_id VARCHAR(50) CONSTRAINT dmf_id_pk PRIMARY KEY,
    dmf_montant NUMBER(18,2),
    dmf_closed NUMBER(1,0),
    dmf_fns_id VARCHAR(50),
CONSTRAINT FK_dmf_id FOREIGN KEY (dmf_fns_id) REFERENCES fournisseur_fns(fns_id)
);

CREATE TABLE demandegarant_dmg
(
    dmg_id VARCHAR(50) CONSTRAINT dmg_id_pk PRIMARY KEY,
    dmg_montant NUMBER(18,2),
    dmp_crd NUMBER(18,2),
    dmg_closed NUMBER(1,0),
    dmg_grt_id VARCHAR(50),
CONSTRAINT FK_dmg_id FOREIGN KEY (dmg_grt_id) REFERENCES garant_grt(grt_id)
);

