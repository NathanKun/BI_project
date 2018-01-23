-- A_UTILISATEUR contains Commerciaux
INSERT INTO COMMERCIAL_CMC (CMC_ID, CMC_NOM, CMC_PRENOM)
    SELECT UTILISATEUR_ID, NOM, PRENOM FROM A_UTILISATEUR;

-- A_ACTEUR contains FOURN GAR PART
INSERT INTO FOURNISSEUR_FNS (FNS_ID, FNS_NOM, FNS_SIRET)
    SELECT ACT_ID, NOM, SIRET FROM A_ACTEUR WHERE A_ACTEUR.TYPE_ACTEUR = 'FOURN';
INSERT INTO GARANT_GRT (GRT_ID, GRT_NOM, GRT_SIRET, GRT_CAPITALSOCIAL)
    SELECT ACT_ID, NOM, SIRET, CAPITAL_SOCIAL FROM A_ACTEUR WHERE A_ACTEUR.TYPE_ACTEUR = 'GAR';
INSERT INTO PARTENAIRE_PTN (PTN_ID, PTN_NOM, PTN_SIRET, PTN_CAPITALSOCIAL)
    SELECT ACT_ID, NOM, SIRET, CAPITAL_SOCIAL FROM A_ACTEUR WHERE A_ACTEUR.TYPE_ACTEUR = 'PART';


-- Complet DATE_DTE
CREATE OR REPLACE PROCEDURE TRANSFORM_DATE AS
start_date DATE;
end_date DATE;
loop_date DATE;
date_dte_id NUMBER(3) := 1;
BEGIN
    -- find first date and last date
    SELECT * INTO start_date FROM (
        SELECT CREATION_DATE FROM A_DEMANDE ORDER BY CREATION_DATE ASC
    ) WHERE ROWNUM <= 1;
    
    SELECT * INTO end_date FROM (
        SELECT CREATION_DATE FROM A_DEMANDE ORDER BY CREATION_DATE DESC
    ) WHERE ROWNUM <= 1;
    --dbms_output.put_line(start_date);
    --dbms_output.put_line(end_date);
    
    -- generate date list
    loop_date := start_date;
    WHILE loop_date < end_date
    LOOP
       dbms_output.put_line(date_dte_id);
       dbms_output.put_line(loop_date);
       dbms_output.put_line(EXTRACT(year FROM loop_date));
       dbms_output.put_line(EXTRACT(month FROM loop_date));
       INSERT INTO DATE_DTE VALUES(
           date_dte_id, loop_date, 
           EXTRACT(year FROM loop_date), 
           EXTRACT(month FROM loop_date)
       );
       date_dte_id := date_dte_id + 1;
       loop_date := ADD_MONTHS(loop_date, 1);
    END LOOP;
END TRANSFORM_DATE;
/

--
BEGIN TRANSFORM_DATE(); END;
