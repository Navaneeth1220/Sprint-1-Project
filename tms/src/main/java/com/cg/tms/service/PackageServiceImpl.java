package com.cg.tms.service;

import java.util.Optional;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.tms.repository.*;
import com.cg.tms.exceptions.*;
import com.cg.tms.exceptions.PackageNotFoundException;
import com.cg.tms.entities.Package;

@Service
public class PackageServiceImpl implements IPackageService {

	@Autowired
	private IPackageRepository packageRepository;

	/*
	 * 
	 * Adds a Package to the database after validation
	 * 
	 * @param pack is Package
	 * @return saved Package
	 * 
	 * */
	@Transactional
	@Override
	public Package addPackage(Package pack) {

		validatePackage(pack);
		Package saved = packageRepository.save(pack);
		return saved;
	}

	/*
	 * 
	 * Deletes a Package from the database after validation based on packageId
	 * 
	 * @param packageId is Package Id
	 * @return deleted Package
	 * 
	 * */
	@Transactional
	@Override
	public Package deletePackage(int packageId) throws PackageNotFoundException {

		validatePackageId(packageId);
		Package pack = searchPackage(packageId);
		packageRepository.deleteById(packageId);
		return pack;
	}

	/*
	 * 
	 * Searches a Package from the database after validation based on packageId
	 * 
	 * @param packageId is Package Id
	 * @return searched Package
	 * 
	 * */
	@Override
	public Package searchPackage(int packageId) throws PackageNotFoundException {

		validatePackageId(packageId);
		Optional<Package> optional = packageRepository.findById(packageId);
		if (!optional.isPresent()) {

			throw new PackageNotFoundException("package not found for packageId=" + packageId);
		}
		return optional.get();

	}

	/*
	 * 
	 * All Packages viewable
	 * 
	 * @return List of all Packages
	 * 
	 * */
	@Override
	public List<Package> viewAllPackages() {

		List<Package> viewAllPackages = packageRepository.findAll();

		return viewAllPackages;

	}

	/*
	 * 
	 * Validates Package Id in Package
	 * 
	 * @param packageId is a data member of Package
	 * @return void
	 * 
	 * */
	public void validatePackageId(int packageId) {

		if (packageId < 0) {

			throw new InvalidPackageIdException("packageId should not be negative");
		}
	}

	/*
	 * 
	 * Validates Package Name in Package
	 * 
	 * @param packageName is a data member of Package
	 * @return void
	 * 
	 * */
	public void validatePackageName(String packageName) {

		if (packageName == null || packageName.isEmpty() || packageName.trim().isEmpty()) {

			throw new InvalidPackageNameException("packageName can't be null or empty");
		}
	}

	/*
	 * 
	 * Validates Package Description in Package
	 * 
	 * @param packageDescription is a data member of Package
	 * @return void
	 * 
	 * */
	public void validatePackageDescription(String packageDescription) {

		if (packageDescription == null || packageDescription.isEmpty() || packageDescription.trim().isEmpty()
				|| packageDescription.length() < 10) {

			throw new InvalidPackageDescriptionException("packageDescription can't be null or empty");
		}
	}

	/*
	 * 
	 * Validates Package Type in Package
	 * 
	 * @param packageType is a data member of Package
	 * @return void
	 * 
	 * */
	public void validatePackageType(String packageType) {

		if (packageType == null || packageType.isEmpty() || packageType.trim().isEmpty() || packageType.length() > 10) {

			throw new InvalidPackageTypeException("packageType can't be null or empty");
		}
	}


	/*
	 * 
	 * Validates a Package 
	 * 
	 * @param pack is Package
	 * @return void
	 * 
	 * */
	public void validatePackage(Package pack) {

		validatePackageName(pack.getPackageName());
		validatePackageDescription(pack.getPackageDescription());
		validatePackageType(pack.getPackageType());

	}

}
