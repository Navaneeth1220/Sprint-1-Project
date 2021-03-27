package com.cg.tms.service;

import com.cg.tms.exceptions.*;
import com.cg.tms.entities.Package;

import java.util.*;

public interface IPackageService {

	public Package addPackage(Package pack);

	public Package deletePackage(int packageId) throws PackageNotFoundException;

	public Package searchPackage(int packageId) throws PackageNotFoundException;

	public List<Package> viewAllPackages();

}
