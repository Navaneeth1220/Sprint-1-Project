package com.cg.tms.service;

import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import com.cg.tms.repository.*;
import org.junit.jupiter.api.Assertions;
import com.cg.tms.entities.Package;
import org.junit.jupiter.api.function.Executable;
import com.cg.tms.exceptions.*;
import java.util.Optional;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PackageServiceUnitTestImpl {

	@Mock
	IPackageRepository packageRepository;

	@Spy
	@InjectMocks
	PackageServiceImpl packageService;

	/**
	 * Scenario 1a: Add Package: Success
	 * Test Case: Add Package
	 */
	@Test
	public void testAdd_Package1() {

		Package pack = mock(Package.class);
		Package saved = mock(Package.class);
		when(packageRepository.save(pack)).thenReturn(saved);
		doNothing().when(packageService).validatePackage(pack);
		Package result = packageService.addPackage(pack);
		Assertions.assertSame(saved, result);
		verify(packageService).validatePackage(pack);
		verify(packageRepository).save(pack);
	}

	/**
	 * Scenario 1b: Add Package: Failure
	 * Test Case: Throw InvalidPackageNameException for Empty Package Name
	 */
	@Test
	public void testAdd_Package2() {

		String packageName = "";
		Package pack = mock(Package.class);
		when(pack.getPackageName()).thenReturn(packageName);
		doThrow(InvalidPackageNameException.class).when(packageService).validatePackageName(packageName);
		Executable executable = () -> packageService.addPackage(pack);
		Assertions.assertThrows(InvalidPackageNameException.class, executable);
		verify(packageRepository, never()).save(pack);

	}

	/**
	 * Scenario 2a: Package Id Validation: Success
	 * Test Case: PackageId provided does not throw any exception  
	 */
	@Test
	public void testValidatePackageId_1() {

		int packageId = 2;
		packageService.validatePackageId(packageId);

	}

	/**
	 * Scenario 2b: Package Id Validation - Negative PackageId
	 * Test Case: Package Id provided is negative which throws InvalidPackageIdException
	 */
	@Test
	public void testValidatePackageId_2() {
		int packageId = -20;
		Executable executable = () -> packageService.validatePackageId(packageId);
		Assertions.assertThrows(InvalidPackageIdException.class, executable);

	}

	/**
	 * Scenario 3a: Package Name Validation - Empty Input
	 * Test Case: Package Name provided is empty which throws InvalidPackageNameException
	 */
	@Test
	public void testValidatePackageName_1() {

		String packageName = "";
		Executable executable = () -> packageService.validatePackageName(packageName);
		Assertions.assertThrows(InvalidPackageNameException.class, executable);

	}

	/**
	 * Scenario 3b: Package Name Validation - Null Input
	 * Test Case: Package Name provided is null which throws InvalidPackageNameException
	 */

	@Test
	public void testValidatePackageName_2() {

		String packageName = null;
		Executable executable = () -> packageService.validatePackageName(packageName);
		Assertions.assertThrows(InvalidPackageNameException.class, executable);

	}

	/**
	 * Scenario 3c: Package Name Validation - Name Not Empty
	 * Test Case: Package Name provided is valid which validates successfully
	 */
	@Test
	public void testValidatePackageName_3() {

		String packageName = "Holiday";
		packageService.validatePackageName(packageName);
	}

	/**
	 * Scenario 4a: Package Description Validation - Empty Input
	 * Test Case:  Package Description provided is empty which throws InvalidPackageDescriptionException
	 */
	@Test
	public void testValidatePackageDescription_1() {

		String packageDescription = "";
		Executable executable = () -> packageService.validatePackageDescription(packageDescription);
		Assertions.assertThrows(InvalidPackageDescriptionException.class, executable);

	}

	/**
	 * Scenario 4b: Package Description Validation - Null Input
	 * Test Case:  Package Description provided is null which throws InvalidPackageDescriptionException
	 */
	@Test
	public void testValidatePackageDescription_2() {

		String packageDescription = null;
		Executable executable = () -> packageService.validatePackageDescription(packageDescription);
		Assertions.assertThrows(InvalidPackageDescriptionException.class, executable);

	}

	/**
	 * Scenario 4c: Package Description Validation - Length Criteria Not
	 * Satisfied(should be greater than 10)
	 * Test Case:  Package Description provided has string length lesser than 10 which throws InvalidPackageDescriptionException
	 * 
	 */
	@Test
	public void testValidatePackageDescription_3() {

		String packageDescription = "worst";
		Executable executable = () -> packageService.validatePackageDescription(packageDescription);
		Assertions.assertThrows(InvalidPackageDescriptionException.class, executable);

	}

	/**
	 * Scenario 4d: Package Description Validation: Success
	 * Test Case: Package Description provided is valid which validates successfully
	 */
	@Test
	public void testValidatePackageDescription_4() {

		String packageDescription = "diverse and cultural";
		packageService.validatePackageDescription(packageDescription);

	}

	/**
	 * Scenario 5a: PackageType Validation - Empty Input
	 * Test Case: Package Type provided is empty which throws InvalidPackageTypeException
	 */
	@Test
	public void testValidatePackageType_1() {

		String packageType = "";
		Executable executable = () -> packageService.validatePackageType(packageType);
		Assertions.assertThrows(InvalidPackageTypeException.class, executable);

	}

	/**
	 * Scenario 5b: PackageType Validation - Null Input
	 * Test Case: Package Type provided is null which throws InvalidPackageTypeException
	 */
	@Test
	public void testValidatePackageType_2() {

		String packageType = null;
		Executable executable = () -> packageService.validatePackageType(packageType);
		Assertions.assertThrows(InvalidPackageTypeException.class, executable);

	}

	/**
	 * Scenario 5c: PackageType Validation - Length Criteria Not Satisfied(should be
	 * less than 10)
	 * Test Case:  Package Type provided has string length greater than 10 which throws InvalidPackageTypeException
	 */
	@Test
	public void testValidatePackageType_3() {

		String packageType = "amazing and astounding";
		Executable executable = () -> packageService.validatePackageType(packageType);
		Assertions.assertThrows(InvalidPackageTypeException.class, executable);

	}

	/**
	 * Scenario 5d: PackageType Validation: Success
	 * Test Case: Package Type provided is valid which validates successfully
	 */
	@Test
	public void testValidatePackageType_4() {

		String packageType = "Delux";
		packageService.validatePackageType(packageType);

	}

	/**
	 * Scenario 6a: Package found By packageId to Search: Success
	 * Test Case: Package is searched based on package Id which exists
	 */
	@Test
	public void testSearchPackageById_1() {

		int packageId = 2;
		Package pack = mock(Package.class);
		Optional<Package> optional = Optional.of(pack);
		when(packageRepository.findById(packageId)).thenReturn(optional);
		Package result = packageService.searchPackage(packageId);
		Assertions.assertEquals(pack, result);
		verify(packageRepository).findById(packageId);
	}

	/**
	 * Scenario 6b: Package not foundById to Search: Failure
	 * Test Case:  Package is searched based on package Id which does not exist
	 */
	@Test
	public void testSearchPackageById_2() {

		int packageId = 50;
		Optional<Package> optional = Optional.empty();
		when(packageRepository.findById(packageId)).thenReturn(optional);
		Executable executable = () -> packageService.searchPackage(packageId);
		Assertions.assertThrows(PackageNotFoundException.class, executable);
	}

	/**
	 * Scenario 7a: Package foundById to Delete: Success
	 * Test Case: Package is deleted based on package Id which exists
	 */

	@Test
	public void testDeletePackageById_1() {

		int packageId = 3;
		Package pack = mock(Package.class);
		doReturn(pack).when(packageService).searchPackage(packageId);
		Package result = packageService.deletePackage(packageId);
		Assertions.assertEquals(pack, result);
		verify(packageRepository).deleteById(packageId);

	}

	/**
	 * Scenario 7b: Package not foundById to Delete: Failure
	 * Test Case:  Package is deleted based on package Id which does not exist
	 */
	@Test
	public void testDeletePackageById_2() {

		int packageId = 3;
		Optional<Package> optional = Optional.empty();
		when(packageRepository.findById(packageId)).thenReturn(optional);
		Executable executable = () -> packageService.deletePackage(packageId);
		Assertions.assertThrows(PackageNotFoundException.class, executable);
	}

	/**
	 * Scenario 8a: View All Packages:Success
	 * Test Case: All packages are viewable
	 */
	@Test
	public void testViewAllPackages() {

		List<Package> packages = mock(List.class);
		when(packageRepository.findAll()).thenReturn(packages);
		List<Package> result = packageService.viewAllPackages();
		Assertions.assertSame(packages, result);
		verify(packageRepository).findAll();

	}

}
