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

	@Transactional
	@Override
	public Package addPackage(Package pack) {

		validatePackageName(pack.getPackageName());
		validatePackageDescription(pack.getPackageDescription());
		validatePackageType(pack.getPackageType());

		Package saved =  packageRepository.save(pack);
		return saved;

	}

	@Transactional
	@Override
	public Package deletePackage(int packageId) throws PackageNotFoundException {

		validatePackageId(packageId);
		Optional<Package> optional = packageRepository.findById(packageId);
		if (!optional.isPresent()) {

			throw new PackageNotFoundException("package not found for packageId=" + packageId);
		}

		packageRepository.deleteById(packageId);

		return optional.get();
	}

	@Override
	public Package searchPackage(int packageId) throws PackageNotFoundException {

		validatePackageId(packageId);
		Optional<Package> optional = packageRepository.findById(packageId);
		if (!optional.isPresent()) {

			throw new PackageNotFoundException("package not found for packageId=" + packageId);
		}
		return optional.get();

	}

	@Override
	public List<Package> viewAllPackages() {

		List<Package> viewAllPackages = packageRepository.findAll();
       
		return viewAllPackages;

	}

	public void validatePackageId(int packageId) {

		if (packageId < 0) {

			throw new InvalidPackageIdException("packageId should not be negative");
		}
	}

	public void validatePackageName(String packageName) {

		if (packageName == null || packageName.isEmpty() || packageName.trim().isEmpty()) {

			throw new InvalidPackageNameException("packageName can't be null or empty");
		}
	}

	public void validatePackageDescription(String packageDescription) {

		if (packageDescription == null || packageDescription.isEmpty() || packageDescription.trim().isEmpty()
				|| packageDescription.length() < 10) {

			throw new InvalidPackageDescriptionException("packageDescription can't be null or empty");
		}
	}

	public void validatePackageType(String packageType) {

		if (packageType == null || packageType.isEmpty() || packageType.trim().isEmpty() || packageType.length() > 10) {

			throw new InvalidPackageTypeException("packageType can't be null or empty");
		}
	}

}
