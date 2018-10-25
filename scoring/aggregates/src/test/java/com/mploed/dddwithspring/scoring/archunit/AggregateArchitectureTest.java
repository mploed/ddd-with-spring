package com.mploed.dddwithspring.scoring.archunit;

import com.mploed.dddwithspring.scoring.microarchitecture.Aggregate;
import com.mploed.dddwithspring.scoring.microarchitecture.AggregateBuilder;
import com.mploed.dddwithspring.scoring.agencyResult.AgencyResultAggregate;
import com.mploed.dddwithspring.scoring.applicant.ApplicantAggregate;
import com.mploed.dddwithspring.scoring.financialSituation.FinancialSituationAggregate;
import com.mploed.dddwithspring.scoring.scoringResult.ScoringResultAggregate;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.syntax.elements.ClassesShouldConjunction;
import org.junit.Before;
import org.junit.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class AggregateArchitectureTest {
	private JavaClasses classes;

	@Before
	public void setUp() {
		classes = new ClassFileImporter().importPackagesOf(ScoringResultAggregate.class,
				ApplicantAggregate.class,
				FinancialSituationAggregate.class,
				AgencyResultAggregate.class);
	}
	@Test
	public void entityAndValueObjectVisibilityRule() {

		ClassesShouldConjunction packagePrivateVisibility = classes().that().haveNameNotMatching((".*Test")).and().areNotAnnotatedWith(Aggregate.class).and().areNotAnnotatedWith(AggregateBuilder.class).should().bePackagePrivate();

		packagePrivateVisibility.check(this.classes);

	}


	@Test
	public void aggregateAnnotationRules() {
		ClassesShouldConjunction namingToAnnotation = classes().that().haveNameMatching(".*Aggregate").should().beAnnotatedWith(Aggregate.class);
		namingToAnnotation.check(this.classes);

		ClassesShouldConjunction annotationToNaming = classes().that().areAnnotatedWith(Aggregate.class).should().haveNameMatching(".*Aggregate");
		annotationToNaming.check(this.classes);

	}

	@Test
	public void aggregateVisibilityRule() {

		ClassesShouldConjunction publicVisibility = classes().that().areAnnotatedWith(Aggregate.class).should().bePublic();

		publicVisibility.check(this.classes);

	}

	@Test
	public void aggregateToRootEntityReference() {
		classes().that().areAnnotatedWith(Aggregate.class).should().accessClassesThat().haveNameMatching(".*RootEntity");
	}

}
