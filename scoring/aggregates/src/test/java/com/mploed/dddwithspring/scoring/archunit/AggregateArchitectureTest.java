package com.mploed.dddwithspring.scoring.archunit;

import java.net.URL;

import com.mploed.dddwithspring.scoring.agencyResult.AgencyResultAggregate;
import com.mploed.dddwithspring.scoring.applicant.ApplicantAggregate;
import com.mploed.dddwithspring.scoring.financialSituation.FinancialSituationAggregate;
import com.mploed.dddwithspring.scoring.microarchitecture.Aggregate;
import com.mploed.dddwithspring.scoring.microarchitecture.AggregateBuilder;
import com.mploed.dddwithspring.scoring.scoringResult.ScoringResultAggregate;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ImportOption.DontIncludeTests;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.runner.RunWith;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.plantuml.PlantUmlArchCondition.Configurations.consideringOnlyDependenciesInAnyPackage;
import static com.tngtech.archunit.library.plantuml.PlantUmlArchCondition.adhereToPlantUmlDiagram;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(
        packagesOf = {ScoringResultAggregate.class, ApplicantAggregate.class, FinancialSituationAggregate.class, AgencyResultAggregate.class},
        importOptions = DontIncludeTests.class)
public class AggregateArchitectureTest {
    private static final URL scoringDiagram = AggregateArchitectureTest.class.getResource("scoring.puml");

    @ArchTest
    public static ArchRule entityAndValueObjectVisibilityRule =
            classes()
                    .that().areNotAnnotatedWith(Aggregate.class)
                    .and().areNotAnnotatedWith(AggregateBuilder.class)
                    .should().bePackagePrivate();

    @ArchTest
    public static void aggregateAnnotationRules(JavaClasses importedClasses) {
        ArchRule namingToAnnotation = classes().that().haveSimpleNameEndingWith("Aggregate").should().beAnnotatedWith(Aggregate.class);
        namingToAnnotation.check(importedClasses);

        ArchRule annotationToNaming = classes().that().areAnnotatedWith(Aggregate.class).should().haveSimpleNameEndingWith("Aggregate");
        annotationToNaming.check(importedClasses);
    }

    @ArchTest
    public static ArchRule aggregateVisibilityRule =
            classes().that().areAnnotatedWith(Aggregate.class).should().bePublic();

    @ArchTest
    public static ArchRule aggregateToRootEntityReference =
            classes()
                    .that().areAnnotatedWith(Aggregate.class)
                    .should().accessClassesThat().haveSimpleNameEndingWith("RootEntity");

    @ArchTest
    public static final ArchRule aggregateFrameworkRule =
            classes()
                    .should().onlyDependOnClassesThat().resideInAnyPackage("com.mploed.dddwithspring..", "java..", "");

    @ArchTest
    public static final ArchRule subdomainDependenciesRule =
            classes()
                    .should(adhereToPlantUmlDiagram(scoringDiagram,
                            consideringOnlyDependenciesInAnyPackage("com.mploed.dddwithspring..")));

}
