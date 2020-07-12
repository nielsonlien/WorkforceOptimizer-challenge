package exe.WorkforceOptimizer;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import exe.WorkforceOptimizer.dao.ShiftDAO;

public class ShiftAction {

	private static final Logger logger = LoggerFactory.getLogger(ShiftAction.class);

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Shift Code: ");
		String shiftCode = scan.next();
		System.out.print("Enter Shift Group Code: ");
		String shiftGroupCode = scan.next();
		scan.close();

		ShiftDAO shiftDAO = new ShiftDAO();
		boolean isBelong = shiftDAO.doesShiftBelongToGroup(shiftCode, shiftGroupCode);

		if (isBelong)
			logger.info(shiftCode + " belongs to group " + shiftGroupCode);
		else
			logger.info(shiftCode + " does not belong to group " + shiftGroupCode);
	}
}
