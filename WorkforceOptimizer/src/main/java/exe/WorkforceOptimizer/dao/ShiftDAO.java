package exe.WorkforceOptimizer.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import exe.WorkforceOptimizer.ShiftAction;
import exe.WorkforceOptimizer.entity.ShiftGrouping;
import exe.WorkforceOptimizer.util.HibernateUtil;

public class ShiftDAO {

	private static final Logger logger = LoggerFactory.getLogger(ShiftDAO.class);

	public boolean doesShiftBelongToGroup(String shiftCode, String shiftGroupCode) {
		boolean isBelong = false;

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			String hql = " FROM ShiftGrouping S WHERE S.shiftGroupCode = :shiftGroupCode AND S.shiftCode = :shiftCode";
			Query query = session.createQuery(hql);
			query.setParameter("shiftGroupCode", shiftGroupCode);
			query.setParameter("shiftCode", shiftCode);
			List results = query.getResultList();

			if (results != null && !results.isEmpty()) {
				isBelong = true;
			}
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			logger.error(e.getMessage(), e);
		}

		return isBelong;
	}

}
