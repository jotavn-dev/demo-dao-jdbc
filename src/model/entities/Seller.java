package model.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Seller implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String email;
	private LocalDate birthDate;
	private Double baseSalary;
	
	private Department department;
	
	public Seller() {
	}

	public Seller(Integer id, String name, String email, LocalDate birthDate, Double baseSalary, Department department) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public int hashCode() {
		return Objects.hash(baseSalary, birthDate, email, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seller other = (Seller) obj;
		return Objects.equals(baseSalary, other.baseSalary) && Objects.equals(birthDate, other.birthDate)
				&& Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Seller [id=" + id + ", name=" + name + ", email=" + email + ", birthLocalDate=" + birthDate + ", baseSalary="
				+ baseSalary + ", department=" + department + "]";
	}

	public static class Builder {
		private Integer id;
		private String name;
		private String email;
		private LocalDate birthDate;
		private Double baseSalary;
		private Department department;
		
		public Builder setId(Integer id) {
			this.id = id;
			return this;
		}
		
		public Builder setName(String name) {
			this.name = name;
			return this;
		}
		
		public Builder setEmail(String email) {
			this.email = email;
			return this;
		}
		
		public Builder setBirthDate(LocalDate birthDate) {
			this.birthDate = birthDate;
			return this;
		}
		
		public Builder setBaseSalary(Double baseSalary) {
			this.baseSalary = baseSalary;
			return this;
		}
		
		public Builder setDepartment(Department department) {
			this.department = department;
			return this;
		}

		public Seller build() {
			return new Seller(id, name, email, birthDate, baseSalary, department);
		}
	}
}
