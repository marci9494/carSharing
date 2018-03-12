package com.wwi16.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mysql.fabric.xmlrpc.base.Array;
import com.wwi16.model.Ausstattung;
import com.wwi16.model.Buchung;
import com.wwi16.model.Fahrzeug;
import com.wwi16.model.FahrzeugFarbe;
import com.wwi16.model.FahrzeugHersteller;
import com.wwi16.model.FahrzeugKategorie;
import com.wwi16.model.FahrzeugVermietZeitraum;
import com.wwi16.model.Kraftstoff;
import com.wwi16.model.User;
import com.wwi16.model.VermietZeitraum;
import com.wwi16.util.DateUtil;
import com.wwi16.util.HibernateUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class FahrzeugService.
 */
public class FahrzeugService {

	/**
	 * Search fahrzeug by plz.
	 *
	 * @param plz the plz
	 * @return the list
	 */
	public List<Fahrzeug> searchFahrzeugByPlz(String plz) {

		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		List<Fahrzeug> fahrzeuge = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from Fahrzeug where plz = '" + plz + "'");
			fahrzeuge = (List<Fahrzeug>) query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return fahrzeuge;
	}

	/**
	 * Creates the fahrzeug.
	 *
	 * @param kennzeichen the kennzeichen
	 * @param modell the modell
	 * @param baujahr the baujahr
	 * @param farbe the farbe
	 * @param laufleistung the laufleistung
	 * @param leistung the leistung
	 * @param kraftstoff the kraftstoff
	 * @param sitzplaetze the sitzplaetze
	 * @param tagespreis the tagespreis
	 * @param kilometerpreis the kilometerpreis
	 * @param fahrzeugbild the fahrzeugbild
	 * @param eigentuemerID the eigentuemer ID
	 * @param ausstattung the ausstattung
	 * @return the fahrzeug
	 */
	public Fahrzeug createFahrzeug(String marke, String kennzeichen, String modell, String baujahr, String farbe, String laufleistung,
			String leistung, String kraftstoff, String sitzplaetze, String tagespreis, String kilometerpreis,
			byte[] fahrzeugbild, String eigentuemerID, String[] ausstattung) {

		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		FahrzeugFarbeService farbService = new FahrzeugFarbeService();
		HerstellerService herstellerService = new HerstellerService();
		FahrzeugKategorieService kategorieService = new FahrzeugKategorieService();
		UserService userService = new UserService();
		KraftstoffService kraftstoffService = new KraftstoffService();
		// TODO 1 bei getFahrzeugKategorieById("1") mittel-/langfristig ersetzen
		FahrzeugFarbe foundFarbe = farbService.getFahrzeugFarbeById(farbe);
		FahrzeugHersteller foundHersteller = herstellerService.getHerstellerById(marke);
		FahrzeugKategorie foundKategorie = kategorieService.getFahrzeugKategorieById("1");
		User user = userService.getNutzerById(eigentuemerID);
		Kraftstoff foundKraftstoff = kraftstoffService.getKraftstoffById(kraftstoff);
		Fahrzeug fahrzeug = new Fahrzeug();

		if (foundFarbe != null) {
			fahrzeug.setFarbe(foundFarbe);
			System.out.println(foundFarbe.getName());
		}
		if (foundHersteller != null) {
			fahrzeug.setHersteller(foundHersteller);
			System.out.println(foundHersteller.getName());
		}
		if (foundKategorie != null) {
			fahrzeug.setKategorie(foundKategorie);
			System.out.println(foundKategorie.getName());
		}
		if (user != null) {
			fahrzeug.setEigentuemer(user);
			System.out.println(user.getNachname());
		}
		if (kraftstoff != null) {
			fahrzeug.setKraftstoff(foundKraftstoff);
			System.out.println(foundKraftstoff.getName());
		}

		if (ausstattung != null) {
//			
			AusstattungService ausstattungService = new AusstattungService();
			List<Ausstattung> ausstattungsList = new ArrayList<>();
			for (String ausstattungId : ausstattung) {
				System.out.println("Ausstattungid = " + ausstattungId);
				Ausstattung ausstattungById = ausstattungService.getAusstattungById(ausstattungId);
				ausstattungsList.add(ausstattungById);
				
			}
			fahrzeug.setAusstattung(ausstattungsList);
							
		}
				
		// TODO auskommentierte felder müssen noch in der DB angelegt werden.

		fahrzeug.setKennzeichen(kennzeichen);
		fahrzeug.setLeistung(leistung);
		fahrzeug.setSitzplaetze(sitzplaetze);
		fahrzeug.setModell(modell);
		fahrzeug.setKm_stand(laufleistung);
		fahrzeug.setFahrzeugbild(fahrzeugbild);
		// TODO ersetzen
		fahrzeug.setPlz("89168");
		fahrzeug.setTagespreis(tagespreis);
		fahrzeug.setKilometerpreis(kilometerpreis);
		fahrzeug.setBaujahr(baujahr);

		// Als Eigent�mer wird der eingeloggte User eingetragen
		fahrzeug.setEigentuemer(user);

		try {
			session.save(fahrzeug);
			session.getTransaction().commit();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			session.close();
		}

		return fahrzeug;

	}

	/**
	 * Gets the fahrzeug by id.
	 *
	 * @param publicId the public id
	 * @return the fahrzeug by id
	 */
	public Fahrzeug getFahrzeugById(String publicId) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		Fahrzeug fahrzeug = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from Fahrzeug where id='" + publicId + "'");
			fahrzeug = (Fahrzeug) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return fahrzeug;
	}

	/**
	 * Search fahrzeuge by user.
	 *
	 * @param user the user
	 * @return the list
	 */
	public List<Fahrzeug> searchFahrzeugeByUser(User user) {

		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		List<Fahrzeug> fahrzeuge = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from Fahrzeug where eigentuemer = '" + user.getId() + "'");
			fahrzeuge = (List<Fahrzeug>) query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return fahrzeuge;
	}

	/**
	 * Adds the vermietungs zeitraeume to fahrzeug.
	 *
	 * @param vermietZeitraeume the vermiet zeitraeume
	 * @param carId the car id
	 */
	public void addVermietungsZeitraeumeToFahrzeug(List<VermietZeitraum> vermietZeitraeume, String carId) {
		Fahrzeug fahrzeug = getFahrzeugById(carId);
		for (VermietZeitraum vermietZeitraum : vermietZeitraeume) {
			if (!checkIfVermietZeitraumExists(vermietZeitraum,fahrzeug)) {
				Session session = HibernateUtil.openSession();
				FahrzeugVermietZeitraum vermietZeitraumEntity = new FahrzeugVermietZeitraum();
				vermietZeitraumEntity.setEndDate(DateUtil.parseDate(vermietZeitraum.getEndDate()));
				vermietZeitraumEntity.setStartDate(DateUtil.parseDate(vermietZeitraum.getStartDate()));
				vermietZeitraumEntity.setFahrzeug(fahrzeug);

				try {
					session.save(vermietZeitraumEntity);
					if (!session.getTransaction().wasCommitted()){
						session.getTransaction().commit();
					}
				} catch (Exception e) {

					e.printStackTrace();
				} finally {
					session.close();
				}
			}

		}

	}

	/**
	 * Update fahrzeug.
	 *
	 * @param fahrzeug the fahrzeug
	 * @return the fahrzeug
	 */
	public Fahrzeug updateFahrzeug(Fahrzeug fahrzeug) {
		Session session = HibernateUtil.openSession();
		session.beginTransaction();

		try {
			session.update(fahrzeug);
			session.getTransaction().commit();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			session.close();
		}

		return fahrzeug;
	}

	/**
	 * Check if vermiet zeitraum exists.
	 *
	 * @param vermietZeitraum the vermiet zeitraum
	 * @param fahrzeug the fahrzeug
	 * @return the boolean
	 */
	public Boolean checkIfVermietZeitraumExists(VermietZeitraum vermietZeitraum, Fahrzeug fahrzeug) {

		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		FahrzeugVermietZeitraum foundVermietZeitraum = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from FahrzeugVermietZeitraum where START_DATUM = '"
					+ vermietZeitraum.getStartDate() + "' and END_DATUM='" + vermietZeitraum.getEndDate() + "'"
					+ "and fahrzeug='" + fahrzeug.getId() + "'");
			foundVermietZeitraum = (FahrzeugVermietZeitraum) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		if (foundVermietZeitraum == null) {
			return false;
		} else {
			return true;
		}

	}
    
    /**
     * Delete vermietzeitraum.
     *
     * @param id the id
     */
    public void deleteVermietzeitraum(String id){
    	FahrzeugVermietZeitraum vermietZeitraum = getFahrzeugVermietZeitraumById(id);
    	
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
    	
		try {
			 session.delete(vermietZeitraum);
			 session.getTransaction().commit();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			session.close();
		}
    	
    }
    
    /**
     * Gets the fahrzeug vermiet zeitraum by id.
     *
     * @param publicId the public id
     * @return the fahrzeug vermiet zeitraum by id
     */
    public FahrzeugVermietZeitraum getFahrzeugVermietZeitraumById(String publicId){
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		FahrzeugVermietZeitraum vermietZeitraum = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from FahrzeugVermietZeitraum where id='" + publicId + "'");
			vermietZeitraum = (FahrzeugVermietZeitraum) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return vermietZeitraum;
    }
}
