package com.cg.tms.repository;

import com.cg.tms.exceptions.*;
import java.util.*;
import com.cg.tms.entities.Package;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IPackageRepository extends JpaRepository<Package, Integer> {

	/*@Query("from Package where pack=:packArg")
	public Package addPackage(@Param("packArg") Package pack);

	@Query("from Package where packageId=:packageIdArg")
	public Package deletePackage(@Param("packageIdArg") int packageId) throws PackageNotFoundException;

	@Query("from Package where packageId=:packageIdArg")
	public Package searchPackage(@Param("packageIdArg") int packageId) throws PackageNotFoundException;

	@Query("from Package")
	public List<Package> viewAllPackages();
*/
}

