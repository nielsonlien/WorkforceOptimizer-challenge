package exe.WorkforceOptimizer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shift_grouping")
public class ShiftGrouping {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private String id;

	@Column(name = "shift_group_code")
	private String shiftGroupCode;

	@Column(name = "shift_code")
	private String shiftCode;

	public ShiftGrouping() {

	}

	public ShiftGrouping(String id, String shiftGroupCode, String shiftCode) {
		this.id = id;
		this.shiftGroupCode = shiftGroupCode;
		this.shiftCode = shiftCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getShiftGroupCode() {
		return shiftGroupCode;
	}

	public void setShiftGroupCode(String shiftGroupCode) {
		this.shiftGroupCode = shiftGroupCode;
	}

	public String getShiftCode() {
		return shiftCode;
	}

	public void setShiftCode(String shiftCode) {
		this.shiftCode = shiftCode;
	}

	@Override
	public String toString() {
		return "ShiftGrouping [id=" + id + ", shiftGroupCode=" + shiftGroupCode + ", shiftCode=" + shiftCode + "]";
	}

}
