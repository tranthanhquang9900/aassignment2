package vn.edu.vnuk.model;

import java.util.Scanner;

public class CasualWorker extends Person {
	private int workDay;
	private float earningPerDay;
	
	public int getWorkDay() {
		return workDay;
	}

	public void setWorkDay(int workDay) {
		this.workDay = workDay;
	}

	public float getEarningPerDay() {
		return earningPerDay;
	}

	public void setEarningPerDay(float earningPerDay) {
		this.earningPerDay = earningPerDay;
	}

	private CasualWorker(CasualWorkerBuilder builder) {
		this.id = builder.id;
		this.yearOfBirth = builder.yearOfBirth;
		this.type = builder.type;
		this.name = builder.name;
		this.workDay = builder.workDay;
		this.earningPerDay = builder.earningPerDay;
	}
	
	//Builder Class
	public static class CasualWorkerBuilder {
		private int workDay;
		private float earningPerDay;
		private int id;
		private int yearOfBirth;
		private int type;
		private String name;
		
		public CasualWorkerBuilder(int id, int type) {
			this.id = id;
			this.type = type;
		}
		
		public CasualWorkerBuilder setWorkDay(int workDay) {
			this.workDay = workDay;
			return this;
		}
		
		public CasualWorkerBuilder setEarningPerDay(int earningPerDay) {
			this.earningPerDay = earningPerDay;
			return this;
		}
		
		public CasualWorkerBuilder setYearOfBirth(int yearOfBirth) {
			this.yearOfBirth = yearOfBirth;
			return this;
		}
		
		public CasualWorkerBuilder setName(String name) {
			this.name = name;
			return this;
		}
		
		public CasualWorker build() {
			return new CasualWorker(this);
		}
	}

	@Override
	public String toString() {
		return "CasualWorker [workDay=" + workDay + ", earningPerDay=" + earningPerDay + ", id=" + id + ", yearOfBirth="
				+ yearOfBirth + ", type=" + type + ", name=" + name + "]";
	}

	@Override
	public void input() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter your name: ");
		String name = sc.nextLine();
		System.out.println("Enter your birth year: ");
		int yearOfBirth = sc.nextInt();
		System.out.println("Enter your hometown: ");
		String hometown = sc.nextLine();
		System.out.println("Enter your number of working days: ");
		int workDay = sc.nextInt();
		System.out.println("Enter your earning per working day: ");
		float earningPerDay = sc.nextFloat();
		
	}

}
