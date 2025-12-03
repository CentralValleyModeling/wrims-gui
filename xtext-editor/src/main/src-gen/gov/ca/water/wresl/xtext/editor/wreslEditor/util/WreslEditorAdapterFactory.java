/**
 */
package gov.ca.water.wresl.xtext.editor.wreslEditor.util;

import gov.ca.water.wresl.xtext.editor.wreslEditor.AbsFunction;
import gov.ca.water.wresl.xtext.editor.wreslEditor.AcosFunction;
import gov.ca.water.wresl.xtext.editor.wreslEditor.AcotFunction;
import gov.ca.water.wresl.xtext.editor.wreslEditor.Add;
import gov.ca.water.wresl.xtext.editor.wreslEditor.Alias;
import gov.ca.water.wresl.xtext.editor.wreslEditor.AsinFunction;
import gov.ca.water.wresl.xtext.editor.wreslEditor.Assignment;
import gov.ca.water.wresl.xtext.editor.wreslEditor.AtanFunction;
import gov.ca.water.wresl.xtext.editor.wreslEditor.CaseContent;
import gov.ca.water.wresl.xtext.editor.wreslEditor.Condition;
import gov.ca.water.wresl.xtext.editor.wreslEditor.ConditionalTerm;
import gov.ca.water.wresl.xtext.editor.wreslEditor.ConditionalUnary;
import gov.ca.water.wresl.xtext.editor.wreslEditor.ConstDef;
import gov.ca.water.wresl.xtext.editor.wreslEditor.Constraint;
import gov.ca.water.wresl.xtext.editor.wreslEditor.CosFunction;
import gov.ca.water.wresl.xtext.editor.wreslEditor.CotFunction;
import gov.ca.water.wresl.xtext.editor.wreslEditor.DVar;
import gov.ca.water.wresl.xtext.editor.wreslEditor.DVarInteger;
import gov.ca.water.wresl.xtext.editor.wreslEditor.DVarIntegerNonStd;
import gov.ca.water.wresl.xtext.editor.wreslEditor.DVarIntegerStd;
import gov.ca.water.wresl.xtext.editor.wreslEditor.DVarNonStd;
import gov.ca.water.wresl.xtext.editor.wreslEditor.DVarStd;
import gov.ca.water.wresl.xtext.editor.wreslEditor.DecisionVariable;
import gov.ca.water.wresl.xtext.editor.wreslEditor.Declaration;
import gov.ca.water.wresl.xtext.editor.wreslEditor.DvarDef;
import gov.ca.water.wresl.xtext.editor.wreslEditor.ElseIfTerm;
import gov.ca.water.wresl.xtext.editor.wreslEditor.ElseTerm;
import gov.ca.water.wresl.xtext.editor.wreslEditor.Expression;
import gov.ca.water.wresl.xtext.editor.wreslEditor.External;
import gov.ca.water.wresl.xtext.editor.wreslEditor.ExternalDef;
import gov.ca.water.wresl.xtext.editor.wreslEditor.ExternalFunction1;
import gov.ca.water.wresl.xtext.editor.wreslEditor.ExternalFunction2;
import gov.ca.water.wresl.xtext.editor.wreslEditor.Function;
import gov.ca.water.wresl.xtext.editor.wreslEditor.Goal;
import gov.ca.water.wresl.xtext.editor.wreslEditor.GoalCase;
import gov.ca.water.wresl.xtext.editor.wreslEditor.GoalCaseContent;
import gov.ca.water.wresl.xtext.editor.wreslEditor.GoalNoCaseContent;
import gov.ca.water.wresl.xtext.editor.wreslEditor.GoalSimple;
import gov.ca.water.wresl.xtext.editor.wreslEditor.Group;
import gov.ca.water.wresl.xtext.editor.wreslEditor.Ident;
import gov.ca.water.wresl.xtext.editor.wreslEditor.IfIncItems;
import gov.ca.water.wresl.xtext.editor.wreslEditor.IfTerm;
import gov.ca.water.wresl.xtext.editor.wreslEditor.IncludeFile;
import gov.ca.water.wresl.xtext.editor.wreslEditor.Initial;
import gov.ca.water.wresl.xtext.editor.wreslEditor.IntFunction;
import gov.ca.water.wresl.xtext.editor.wreslEditor.LhsGtRhs;
import gov.ca.water.wresl.xtext.editor.wreslEditor.LhsLtRhs;
import gov.ca.water.wresl.xtext.editor.wreslEditor.LogFunction;
import gov.ca.water.wresl.xtext.editor.wreslEditor.LogicalExpression;
import gov.ca.water.wresl.xtext.editor.wreslEditor.Lower;
import gov.ca.water.wresl.xtext.editor.wreslEditor.LowerAndOrUpper;
import gov.ca.water.wresl.xtext.editor.wreslEditor.MaxFunction;
import gov.ca.water.wresl.xtext.editor.wreslEditor.MinFunction;
import gov.ca.water.wresl.xtext.editor.wreslEditor.ModFunction;
import gov.ca.water.wresl.xtext.editor.wreslEditor.Model;
import gov.ca.water.wresl.xtext.editor.wreslEditor.Multiply;
import gov.ca.water.wresl.xtext.editor.wreslEditor.Objective;
import gov.ca.water.wresl.xtext.editor.wreslEditor.Pattern;
import gov.ca.water.wresl.xtext.editor.wreslEditor.Penalty;
import gov.ca.water.wresl.xtext.editor.wreslEditor.PowFunction;
import gov.ca.water.wresl.xtext.editor.wreslEditor.RoundFunction;
import gov.ca.water.wresl.xtext.editor.wreslEditor.SVar;
import gov.ca.water.wresl.xtext.editor.wreslEditor.SVarCase;
import gov.ca.water.wresl.xtext.editor.wreslEditor.SVarDSS;
import gov.ca.water.wresl.xtext.editor.wreslEditor.SVarExpression;
import gov.ca.water.wresl.xtext.editor.wreslEditor.SVarSum;
import gov.ca.water.wresl.xtext.editor.wreslEditor.SVarTable;
import gov.ca.water.wresl.xtext.editor.wreslEditor.Sequence;
import gov.ca.water.wresl.xtext.editor.wreslEditor.SinFunction;
import gov.ca.water.wresl.xtext.editor.wreslEditor.StateVariable;
import gov.ca.water.wresl.xtext.editor.wreslEditor.SubContent;
import gov.ca.water.wresl.xtext.editor.wreslEditor.SumContent;
import gov.ca.water.wresl.xtext.editor.wreslEditor.SumHeader;
import gov.ca.water.wresl.xtext.editor.wreslEditor.SvarDef;
import gov.ca.water.wresl.xtext.editor.wreslEditor.TableContent;
import gov.ca.water.wresl.xtext.editor.wreslEditor.TanFunction;
import gov.ca.water.wresl.xtext.editor.wreslEditor.Term;
import gov.ca.water.wresl.xtext.editor.wreslEditor.TermSimple;
import gov.ca.water.wresl.xtext.editor.wreslEditor.TimeArraySize;
import gov.ca.water.wresl.xtext.editor.wreslEditor.TrunkTimeArray;
import gov.ca.water.wresl.xtext.editor.wreslEditor.TrunkTimeArrayIndex;
import gov.ca.water.wresl.xtext.editor.wreslEditor.Unary;
import gov.ca.water.wresl.xtext.editor.wreslEditor.Upper;
import gov.ca.water.wresl.xtext.editor.wreslEditor.ValueContent;
import gov.ca.water.wresl.xtext.editor.wreslEditor.VarModel;
import gov.ca.water.wresl.xtext.editor.wreslEditor.VarModelIndex;
import gov.ca.water.wresl.xtext.editor.wreslEditor.VarModelIndexStep;
import gov.ca.water.wresl.xtext.editor.wreslEditor.VarModelStep;
import gov.ca.water.wresl.xtext.editor.wreslEditor.Variable;
import gov.ca.water.wresl.xtext.editor.wreslEditor.WeightItem;
import gov.ca.water.wresl.xtext.editor.wreslEditor.WhereItems;
import gov.ca.water.wresl.xtext.editor.wreslEditor.WreslEditorPackage;
import gov.ca.water.wresl.xtext.editor.wreslEditor.WreslEvaluator;
import gov.ca.water.wresl.xtext.editor.wreslEditor.lowerUpper;
import gov.ca.water.wresl.xtext.editor.wreslEditor.upperLower;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see WreslEditorPackage
 * @generated
 */
public class WreslEditorAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static WreslEditorPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WreslEditorAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = WreslEditorPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected WreslEditorSwitch<Adapter> modelSwitch =
    new WreslEditorSwitch<Adapter>()
    {
      @Override
      public Adapter caseWreslEvaluator(WreslEvaluator object)
      {
        return createWreslEvaluatorAdapter();
      }
      @Override
      public Adapter casePattern(Pattern object)
      {
        return createPatternAdapter();
      }
      @Override
      public Adapter caseDeclaration(Declaration object)
      {
        return createDeclarationAdapter();
      }
      @Override
      public Adapter caseVariable(Variable object)
      {
        return createVariableAdapter();
      }
      @Override
      public Adapter caseStateVariable(StateVariable object)
      {
        return createStateVariableAdapter();
      }
      @Override
      public Adapter caseDecisionVariable(DecisionVariable object)
      {
        return createDecisionVariableAdapter();
      }
      @Override
      public Adapter caseIfIncItems(IfIncItems object)
      {
        return createIfIncItemsAdapter();
      }
      @Override
      public Adapter caseIfTerm(IfTerm object)
      {
        return createIfTermAdapter();
      }
      @Override
      public Adapter caseElseIfTerm(ElseIfTerm object)
      {
        return createElseIfTermAdapter();
      }
      @Override
      public Adapter caseElseTerm(ElseTerm object)
      {
        return createElseTermAdapter();
      }
      @Override
      public Adapter caseTimeArraySize(TimeArraySize object)
      {
        return createTimeArraySizeAdapter();
      }
      @Override
      public Adapter caseObjective(Objective object)
      {
        return createObjectiveAdapter();
      }
      @Override
      public Adapter caseWeightItem(WeightItem object)
      {
        return createWeightItemAdapter();
      }
      @Override
      public Adapter caseExternalDef(ExternalDef object)
      {
        return createExternalDefAdapter();
      }
      @Override
      public Adapter caseSvarDef(SvarDef object)
      {
        return createSvarDefAdapter();
      }
      @Override
      public Adapter caseDvarDef(DvarDef object)
      {
        return createDvarDefAdapter();
      }
      @Override
      public Adapter caseConstDef(ConstDef object)
      {
        return createConstDefAdapter();
      }
      @Override
      public Adapter caseAlias(Alias object)
      {
        return createAliasAdapter();
      }
      @Override
      public Adapter caseExternal(External object)
      {
        return createExternalAdapter();
      }
      @Override
      public Adapter caseDVar(DVar object)
      {
        return createDVarAdapter();
      }
      @Override
      public Adapter caseDVarNonStd(DVarNonStd object)
      {
        return createDVarNonStdAdapter();
      }
      @Override
      public Adapter caseDVarStd(DVarStd object)
      {
        return createDVarStdAdapter();
      }
      @Override
      public Adapter caseDVarInteger(DVarInteger object)
      {
        return createDVarIntegerAdapter();
      }
      @Override
      public Adapter caseDVarIntegerStd(DVarIntegerStd object)
      {
        return createDVarIntegerStdAdapter();
      }
      @Override
      public Adapter caseDVarIntegerNonStd(DVarIntegerNonStd object)
      {
        return createDVarIntegerNonStdAdapter();
      }
      @Override
      public Adapter caseSVar(SVar object)
      {
        return createSVarAdapter();
      }
      @Override
      public Adapter caseSVarDSS(SVarDSS object)
      {
        return createSVarDSSAdapter();
      }
      @Override
      public Adapter caseSVarExpression(SVarExpression object)
      {
        return createSVarExpressionAdapter();
      }
      @Override
      public Adapter caseSVarSum(SVarSum object)
      {
        return createSVarSumAdapter();
      }
      @Override
      public Adapter caseSVarTable(SVarTable object)
      {
        return createSVarTableAdapter();
      }
      @Override
      public Adapter caseSVarCase(SVarCase object)
      {
        return createSVarCaseAdapter();
      }
      @Override
      public Adapter caseCaseContent(CaseContent object)
      {
        return createCaseContentAdapter();
      }
      @Override
      public Adapter caseSumContent(SumContent object)
      {
        return createSumContentAdapter();
      }
      @Override
      public Adapter caseSumHeader(SumHeader object)
      {
        return createSumHeaderAdapter();
      }
      @Override
      public Adapter caseValueContent(ValueContent object)
      {
        return createValueContentAdapter();
      }
      @Override
      public Adapter caseTableContent(TableContent object)
      {
        return createTableContentAdapter();
      }
      @Override
      public Adapter caseWhereItems(WhereItems object)
      {
        return createWhereItemsAdapter();
      }
      @Override
      public Adapter caseAssignment(Assignment object)
      {
        return createAssignmentAdapter();
      }
      @Override
      public Adapter caseTermSimple(TermSimple object)
      {
        return createTermSimpleAdapter();
      }
      @Override
      public Adapter caseLowerAndOrUpper(LowerAndOrUpper object)
      {
        return createLowerAndOrUpperAdapter();
      }
      @Override
      public Adapter caseupperLower(upperLower object)
      {
        return createupperLowerAdapter();
      }
      @Override
      public Adapter caselowerUpper(lowerUpper object)
      {
        return createlowerUpperAdapter();
      }
      @Override
      public Adapter caseUpper(Upper object)
      {
        return createUpperAdapter();
      }
      @Override
      public Adapter caseLower(Lower object)
      {
        return createLowerAdapter();
      }
      @Override
      public Adapter caseGoal(Goal object)
      {
        return createGoalAdapter();
      }
      @Override
      public Adapter caseGoalCase(GoalCase object)
      {
        return createGoalCaseAdapter();
      }
      @Override
      public Adapter caseGoalCaseContent(GoalCaseContent object)
      {
        return createGoalCaseContentAdapter();
      }
      @Override
      public Adapter caseGoalNoCaseContent(GoalNoCaseContent object)
      {
        return createGoalNoCaseContentAdapter();
      }
      @Override
      public Adapter caseSubContent(SubContent object)
      {
        return createSubContentAdapter();
      }
      @Override
      public Adapter caseLhsGtRhs(LhsGtRhs object)
      {
        return createLhsGtRhsAdapter();
      }
      @Override
      public Adapter caseLhsLtRhs(LhsLtRhs object)
      {
        return createLhsLtRhsAdapter();
      }
      @Override
      public Adapter casePenalty(Penalty object)
      {
        return createPenaltyAdapter();
      }
      @Override
      public Adapter caseGoalSimple(GoalSimple object)
      {
        return createGoalSimpleAdapter();
      }
      @Override
      public Adapter caseConstraint(Constraint object)
      {
        return createConstraintAdapter();
      }
      @Override
      public Adapter caseGroup(Group object)
      {
        return createGroupAdapter();
      }
      @Override
      public Adapter caseModel(Model object)
      {
        return createModelAdapter();
      }
      @Override
      public Adapter caseInitial(Initial object)
      {
        return createInitialAdapter();
      }
      @Override
      public Adapter caseSequence(Sequence object)
      {
        return createSequenceAdapter();
      }
      @Override
      public Adapter caseCondition(Condition object)
      {
        return createConditionAdapter();
      }
      @Override
      public Adapter caseLogicalExpression(LogicalExpression object)
      {
        return createLogicalExpressionAdapter();
      }
      @Override
      public Adapter caseConditionalUnary(ConditionalUnary object)
      {
        return createConditionalUnaryAdapter();
      }
      @Override
      public Adapter caseConditionalTerm(ConditionalTerm object)
      {
        return createConditionalTermAdapter();
      }
      @Override
      public Adapter caseExpression(Expression object)
      {
        return createExpressionAdapter();
      }
      @Override
      public Adapter caseAdd(Add object)
      {
        return createAddAdapter();
      }
      @Override
      public Adapter caseMultiply(Multiply object)
      {
        return createMultiplyAdapter();
      }
      @Override
      public Adapter caseUnary(Unary object)
      {
        return createUnaryAdapter();
      }
      @Override
      public Adapter caseTerm(Term object)
      {
        return createTermAdapter();
      }
      @Override
      public Adapter caseFunction(Function object)
      {
        return createFunctionAdapter();
      }
      @Override
      public Adapter caseExternalFunction1(ExternalFunction1 object)
      {
        return createExternalFunction1Adapter();
      }
      @Override
      public Adapter caseExternalFunction2(ExternalFunction2 object)
      {
        return createExternalFunction2Adapter();
      }
      @Override
      public Adapter caseTrunkTimeArray(TrunkTimeArray object)
      {
        return createTrunkTimeArrayAdapter();
      }
      @Override
      public Adapter caseTrunkTimeArrayIndex(TrunkTimeArrayIndex object)
      {
        return createTrunkTimeArrayIndexAdapter();
      }
      @Override
      public Adapter caseMaxFunction(MaxFunction object)
      {
        return createMaxFunctionAdapter();
      }
      @Override
      public Adapter caseMinFunction(MinFunction object)
      {
        return createMinFunctionAdapter();
      }
      @Override
      public Adapter caseModFunction(ModFunction object)
      {
        return createModFunctionAdapter();
      }
      @Override
      public Adapter caseIntFunction(IntFunction object)
      {
        return createIntFunctionAdapter();
      }
      @Override
      public Adapter caseAbsFunction(AbsFunction object)
      {
        return createAbsFunctionAdapter();
      }
      @Override
      public Adapter caseRoundFunction(RoundFunction object)
      {
        return createRoundFunctionAdapter();
      }
      @Override
      public Adapter casePowFunction(PowFunction object)
      {
        return createPowFunctionAdapter();
      }
      @Override
      public Adapter caseLogFunction(LogFunction object)
      {
        return createLogFunctionAdapter();
      }
      @Override
      public Adapter caseSinFunction(SinFunction object)
      {
        return createSinFunctionAdapter();
      }
      @Override
      public Adapter caseCosFunction(CosFunction object)
      {
        return createCosFunctionAdapter();
      }
      @Override
      public Adapter caseTanFunction(TanFunction object)
      {
        return createTanFunctionAdapter();
      }
      @Override
      public Adapter caseCotFunction(CotFunction object)
      {
        return createCotFunctionAdapter();
      }
      @Override
      public Adapter caseAsinFunction(AsinFunction object)
      {
        return createAsinFunctionAdapter();
      }
      @Override
      public Adapter caseAcosFunction(AcosFunction object)
      {
        return createAcosFunctionAdapter();
      }
      @Override
      public Adapter caseAtanFunction(AtanFunction object)
      {
        return createAtanFunctionAdapter();
      }
      @Override
      public Adapter caseAcotFunction(AcotFunction object)
      {
        return createAcotFunctionAdapter();
      }
      @Override
      public Adapter caseVarModel(VarModel object)
      {
        return createVarModelAdapter();
      }
      @Override
      public Adapter caseVarModelStep(VarModelStep object)
      {
        return createVarModelStepAdapter();
      }
      @Override
      public Adapter caseVarModelIndex(VarModelIndex object)
      {
        return createVarModelIndexAdapter();
      }
      @Override
      public Adapter caseVarModelIndexStep(VarModelIndexStep object)
      {
        return createVarModelIndexStepAdapter();
      }
      @Override
      public Adapter caseIdent(Ident object)
      {
        return createIdentAdapter();
      }
      @Override
      public Adapter caseIncludeFile(IncludeFile object)
      {
        return createIncludeFileAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link WreslEvaluator <em>Wresl Evaluator</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see WreslEvaluator
   * @generated
   */
  public Adapter createWreslEvaluatorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link Pattern <em>Pattern</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see Pattern
   * @generated
   */
  public Adapter createPatternAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link Declaration <em>Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see Declaration
   * @generated
   */
  public Adapter createDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link Variable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see Variable
   * @generated
   */
  public Adapter createVariableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link StateVariable <em>State Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see StateVariable
   * @generated
   */
  public Adapter createStateVariableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link DecisionVariable <em>Decision Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see DecisionVariable
   * @generated
   */
  public Adapter createDecisionVariableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link IfIncItems <em>If Inc Items</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see IfIncItems
   * @generated
   */
  public Adapter createIfIncItemsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link IfTerm <em>If Term</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see IfTerm
   * @generated
   */
  public Adapter createIfTermAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ElseIfTerm <em>Else If Term</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ElseIfTerm
   * @generated
   */
  public Adapter createElseIfTermAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ElseTerm <em>Else Term</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ElseTerm
   * @generated
   */
  public Adapter createElseTermAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link TimeArraySize <em>Time Array Size</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see TimeArraySize
   * @generated
   */
  public Adapter createTimeArraySizeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link Objective <em>Objective</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see Objective
   * @generated
   */
  public Adapter createObjectiveAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link WeightItem <em>Weight Item</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see WeightItem
   * @generated
   */
  public Adapter createWeightItemAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ExternalDef <em>External Def</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ExternalDef
   * @generated
   */
  public Adapter createExternalDefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link SvarDef <em>Svar Def</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see SvarDef
   * @generated
   */
  public Adapter createSvarDefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link DvarDef <em>Dvar Def</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see DvarDef
   * @generated
   */
  public Adapter createDvarDefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ConstDef <em>Const Def</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ConstDef
   * @generated
   */
  public Adapter createConstDefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link Alias <em>Alias</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see Alias
   * @generated
   */
  public Adapter createAliasAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link External <em>External</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see External
   * @generated
   */
  public Adapter createExternalAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link DVar <em>DVar</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see DVar
   * @generated
   */
  public Adapter createDVarAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link DVarNonStd <em>DVar Non Std</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see DVarNonStd
   * @generated
   */
  public Adapter createDVarNonStdAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link DVarStd <em>DVar Std</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see DVarStd
   * @generated
   */
  public Adapter createDVarStdAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link DVarInteger <em>DVar Integer</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see DVarInteger
   * @generated
   */
  public Adapter createDVarIntegerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link DVarIntegerStd <em>DVar Integer Std</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see DVarIntegerStd
   * @generated
   */
  public Adapter createDVarIntegerStdAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link DVarIntegerNonStd <em>DVar Integer Non Std</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see DVarIntegerNonStd
   * @generated
   */
  public Adapter createDVarIntegerNonStdAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link SVar <em>SVar</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see SVar
   * @generated
   */
  public Adapter createSVarAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link SVarDSS <em>SVar DSS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see SVarDSS
   * @generated
   */
  public Adapter createSVarDSSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link SVarExpression <em>SVar Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see SVarExpression
   * @generated
   */
  public Adapter createSVarExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link SVarSum <em>SVar Sum</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see SVarSum
   * @generated
   */
  public Adapter createSVarSumAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link SVarTable <em>SVar Table</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see SVarTable
   * @generated
   */
  public Adapter createSVarTableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link SVarCase <em>SVar Case</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see SVarCase
   * @generated
   */
  public Adapter createSVarCaseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link CaseContent <em>Case Content</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see CaseContent
   * @generated
   */
  public Adapter createCaseContentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link SumContent <em>Sum Content</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see SumContent
   * @generated
   */
  public Adapter createSumContentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link SumHeader <em>Sum Header</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see SumHeader
   * @generated
   */
  public Adapter createSumHeaderAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ValueContent <em>Value Content</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ValueContent
   * @generated
   */
  public Adapter createValueContentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link TableContent <em>Table Content</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see TableContent
   * @generated
   */
  public Adapter createTableContentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link WhereItems <em>Where Items</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see WhereItems
   * @generated
   */
  public Adapter createWhereItemsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link Assignment <em>Assignment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see Assignment
   * @generated
   */
  public Adapter createAssignmentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link TermSimple <em>Term Simple</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see TermSimple
   * @generated
   */
  public Adapter createTermSimpleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link LowerAndOrUpper <em>Lower And Or Upper</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see LowerAndOrUpper
   * @generated
   */
  public Adapter createLowerAndOrUpperAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link upperLower <em>upper Lower</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see upperLower
   * @generated
   */
  public Adapter createupperLowerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link lowerUpper <em>lower Upper</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see lowerUpper
   * @generated
   */
  public Adapter createlowerUpperAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link Upper <em>Upper</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see Upper
   * @generated
   */
  public Adapter createUpperAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link Lower <em>Lower</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see Lower
   * @generated
   */
  public Adapter createLowerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link Goal <em>Goal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see Goal
   * @generated
   */
  public Adapter createGoalAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link GoalCase <em>Goal Case</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see GoalCase
   * @generated
   */
  public Adapter createGoalCaseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link GoalCaseContent <em>Goal Case Content</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see GoalCaseContent
   * @generated
   */
  public Adapter createGoalCaseContentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link GoalNoCaseContent <em>Goal No Case Content</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see GoalNoCaseContent
   * @generated
   */
  public Adapter createGoalNoCaseContentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link SubContent <em>Sub Content</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see SubContent
   * @generated
   */
  public Adapter createSubContentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link LhsGtRhs <em>Lhs Gt Rhs</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see LhsGtRhs
   * @generated
   */
  public Adapter createLhsGtRhsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link LhsLtRhs <em>Lhs Lt Rhs</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see LhsLtRhs
   * @generated
   */
  public Adapter createLhsLtRhsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link Penalty <em>Penalty</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see Penalty
   * @generated
   */
  public Adapter createPenaltyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link GoalSimple <em>Goal Simple</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see GoalSimple
   * @generated
   */
  public Adapter createGoalSimpleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link Constraint <em>Constraint</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see Constraint
   * @generated
   */
  public Adapter createConstraintAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link Group <em>Group</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see Group
   * @generated
   */
  public Adapter createGroupAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see Model
   * @generated
   */
  public Adapter createModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link Initial <em>Initial</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see Initial
   * @generated
   */
  public Adapter createInitialAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link Sequence <em>Sequence</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see Sequence
   * @generated
   */
  public Adapter createSequenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link Condition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see Condition
   * @generated
   */
  public Adapter createConditionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link LogicalExpression <em>Logical Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see LogicalExpression
   * @generated
   */
  public Adapter createLogicalExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ConditionalUnary <em>Conditional Unary</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ConditionalUnary
   * @generated
   */
  public Adapter createConditionalUnaryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ConditionalTerm <em>Conditional Term</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ConditionalTerm
   * @generated
   */
  public Adapter createConditionalTermAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see Expression
   * @generated
   */
  public Adapter createExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link Add <em>Add</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see Add
   * @generated
   */
  public Adapter createAddAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link Multiply <em>Multiply</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see Multiply
   * @generated
   */
  public Adapter createMultiplyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link Unary <em>Unary</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see Unary
   * @generated
   */
  public Adapter createUnaryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link Term <em>Term</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see Term
   * @generated
   */
  public Adapter createTermAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link Function <em>Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see Function
   * @generated
   */
  public Adapter createFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ExternalFunction1 <em>External Function1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ExternalFunction1
   * @generated
   */
  public Adapter createExternalFunction1Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ExternalFunction2 <em>External Function2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ExternalFunction2
   * @generated
   */
  public Adapter createExternalFunction2Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link TrunkTimeArray <em>Trunk Time Array</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see TrunkTimeArray
   * @generated
   */
  public Adapter createTrunkTimeArrayAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link TrunkTimeArrayIndex <em>Trunk Time Array Index</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see TrunkTimeArrayIndex
   * @generated
   */
  public Adapter createTrunkTimeArrayIndexAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link MaxFunction <em>Max Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see MaxFunction
   * @generated
   */
  public Adapter createMaxFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link MinFunction <em>Min Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see MinFunction
   * @generated
   */
  public Adapter createMinFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ModFunction <em>Mod Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ModFunction
   * @generated
   */
  public Adapter createModFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link IntFunction <em>Int Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see IntFunction
   * @generated
   */
  public Adapter createIntFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link AbsFunction <em>Abs Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see AbsFunction
   * @generated
   */
  public Adapter createAbsFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link RoundFunction <em>Round Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see RoundFunction
   * @generated
   */
  public Adapter createRoundFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link PowFunction <em>Pow Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see PowFunction
   * @generated
   */
  public Adapter createPowFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link LogFunction <em>Log Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see LogFunction
   * @generated
   */
  public Adapter createLogFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link SinFunction <em>Sin Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see SinFunction
   * @generated
   */
  public Adapter createSinFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link CosFunction <em>Cos Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see CosFunction
   * @generated
   */
  public Adapter createCosFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link TanFunction <em>Tan Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see TanFunction
   * @generated
   */
  public Adapter createTanFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link CotFunction <em>Cot Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see CotFunction
   * @generated
   */
  public Adapter createCotFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link AsinFunction <em>Asin Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see AsinFunction
   * @generated
   */
  public Adapter createAsinFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link AcosFunction <em>Acos Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see AcosFunction
   * @generated
   */
  public Adapter createAcosFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link AtanFunction <em>Atan Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see AtanFunction
   * @generated
   */
  public Adapter createAtanFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link AcotFunction <em>Acot Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see AcotFunction
   * @generated
   */
  public Adapter createAcotFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link VarModel <em>Var Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see VarModel
   * @generated
   */
  public Adapter createVarModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link VarModelStep <em>Var Model Step</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see VarModelStep
   * @generated
   */
  public Adapter createVarModelStepAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link VarModelIndex <em>Var Model Index</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see VarModelIndex
   * @generated
   */
  public Adapter createVarModelIndexAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link VarModelIndexStep <em>Var Model Index Step</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see VarModelIndexStep
   * @generated
   */
  public Adapter createVarModelIndexStepAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link Ident <em>Ident</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see Ident
   * @generated
   */
  public Adapter createIdentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link IncludeFile <em>Include File</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see IncludeFile
   * @generated
   */
  public Adapter createIncludeFileAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //WreslEditorAdapterFactory
