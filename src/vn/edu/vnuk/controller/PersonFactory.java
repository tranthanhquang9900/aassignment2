package vn.edu.vnuk.controller;

import vn.edu.vnuk.define.Define;
import vn.edu.vnuk.model.CasualWorker;
import vn.edu.vnuk.model.Lecturer;
import vn.edu.vnuk.model.Person;
import vn.edu.vnuk.model.Staff;


public class PersonFactory {
	
	public static Person getPerson(int type) {
		Define.latestId++;
		
		switch (type) {
		case Define.TYPE_OF_LECTURER: return new Lecturer.LecturerBuilder(Define.latestId, type).build();
		case Define.TYPE_OF_STAFF: return new Staff.StaffBuilder(Define.latestId, type).build();
		case Define.TYPE_OF_CASUAL_WORKER: return new CasualWorker.CasualWorkerBuilder(Define.latestId, type).build();
		}
		
		return null;
	}
}
