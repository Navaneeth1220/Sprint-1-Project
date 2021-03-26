package com.cg.tms.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.*;
import com.cg.tms.service.*;
import com.cg.tms.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.cg.tms.dto.*;
import com.cg.tms.entities.Package;
import java.util.*;
import org.springframework.http.HttpStatus;

@RequestMapping("/packages")
@RestController
public class PackageRestController {

	private static final Logger LOG = LoggerFactory.getLogger(PackageRestController.class);

	@Autowired
	private IPackageService packageService;

	@Autowired
	private PackageUtil packageUtil;

	@GetMapping(value = "/byid/{id}")
	public PackageDetails fetchPackage(@PathVariable("id") int packageId) {

		LOG.debug("packageId in fetchpackage in PackageRestController " + packageId);
		Package pack = packageService.searchPackage(packageId);
		PackageDetails packageDetails = packageUtil.toDetailPackage(pack);
		return packageDetails;
	}

	@GetMapping
	public List<PackageDetails> allPackages() {

		List<Package> packs = packageService.viewAllPackages();
		List<PackageDetails> packageDetails = packageUtil.toDetailsPackages(packs);
		return packageDetails;
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/addPackage")
	public String addPackage(@RequestBody CreatePackageRequest requestData) {

		Package pack = new Package();
		pack.setPackageName(requestData.getPackageName());
		pack.setPackageDescription(requestData.getPackageDescription());
		pack.setPackageType(requestData.getPackageType());
		pack.setPackageCost(requestData.getPackageCost());
		Package added = packageService.addPackage(pack);
		return "added package with packageId =" + added.getPackageId();
	}

	@DeleteMapping("/deletePackage")
	public String delete(@RequestBody DeletePackageRequest requestData) {

		packageService.deletePackage(requestData.getPackageId());
		return "package deleted for packageId=" + requestData.getPackageId();
	}

}
