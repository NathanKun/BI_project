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
