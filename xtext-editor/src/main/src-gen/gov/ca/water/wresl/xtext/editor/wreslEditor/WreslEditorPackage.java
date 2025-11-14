/**
 */
package gov.ca.water.wresl.xtext.editor.wreslEditor;

import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.AbsFunctionImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.AcosFunctionImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.AcotFunctionImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.AddImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.AliasImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.AsinFunctionImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.AssignmentImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.AtanFunctionImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.CaseContentImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.ConditionImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.ConditionalTermImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.ConditionalUnaryImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.ConstDefImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.ConstraintImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.CosFunctionImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.CotFunctionImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.DVarImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.DVarIntegerImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.DVarIntegerNonStdImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.DVarIntegerStdImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.DVarNonStdImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.DVarStdImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.DecisionVariableImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.DeclarationImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.DvarDefImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.ElseIfTermImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.ElseTermImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.ExpressionImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.ExternalDefImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.ExternalFunction1Impl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.ExternalFunction2Impl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.ExternalImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.FunctionImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.GoalCaseContentImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.GoalCaseImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.GoalImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.GoalNoCaseContentImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.GoalSimpleImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.GroupImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.IdentImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.IfIncItemsImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.IfTermImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.IncludeFileImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.InitialImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.IntFunctionImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.LhsGtRhsImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.LhsLtRhsImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.LogFunctionImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.LogicalExpressionImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.LowerAndOrUpperImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.LowerImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.MaxFunctionImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.MinFunctionImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.ModFunctionImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.ModelImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.MultiplyImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.ObjectiveImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.PatternImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.PenaltyImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.PowFunctionImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.RoundFunctionImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.SVarCaseImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.SVarDSSImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.SVarExpressionImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.SVarImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.SVarSumImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.SVarTableImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.SequenceImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.SinFunctionImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.StateVariableImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.SubContentImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.SumContentImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.SumHeaderImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.SvarDefImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.TableContentImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.TanFunctionImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.TermImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.TermSimpleImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.TimeArraySizeImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.TrunkTimeArrayImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.TrunkTimeArrayIndexImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.UnaryImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.UpperImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.ValueContentImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.VarModelImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.VarModelIndexImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.VarModelIndexStepImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.VarModelStepImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.VariableImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.WeightItemImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.WhereItemsImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.WreslEvaluatorImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.lowerUpperImpl;
import gov.ca.water.wresl.xtext.editor.wreslEditor.impl.upperLowerImpl;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see WreslEditorFactory
 * @model kind="package"
 * @generated
 */
public interface WreslEditorPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "wreslEditor";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.ca.gov/dwr/wresl/xtext/editor/WreslEditor";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "wreslEditor";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  WreslEditorPackage eINSTANCE = WreslEditorPackageImpl.init();

  /**
   * The meta object id for the '{@link WreslEvaluatorImpl <em>Wresl Evaluator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see WreslEvaluatorImpl
   * @see WreslEditorPackageImpl#getWreslEvaluator()
   * @generated
   */
  int WRESL_EVALUATOR = 0;

  /**
   * The feature id for the '<em><b>Pattern</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WRESL_EVALUATOR__PATTERN = 0;

  /**
   * The feature id for the '<em><b>Ifincitem</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WRESL_EVALUATOR__IFINCITEM = 1;

  /**
   * The feature id for the '<em><b>Initial</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WRESL_EVALUATOR__INITIAL = 2;

  /**
   * The feature id for the '<em><b>Sequence</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WRESL_EVALUATOR__SEQUENCE = 3;

  /**
   * The feature id for the '<em><b>Model</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WRESL_EVALUATOR__MODEL = 4;

  /**
   * The number of structural features of the '<em>Wresl Evaluator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WRESL_EVALUATOR_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link PatternImpl <em>Pattern</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PatternImpl
   * @see WreslEditorPackageImpl#getPattern()
   * @generated
   */
  int PATTERN = 1;

  /**
   * The feature id for the '<em><b>Local</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN__LOCAL = 0;

  /**
   * The number of structural features of the '<em>Pattern</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link DeclarationImpl <em>Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see DeclarationImpl
   * @see WreslEditorPackageImpl#getDeclaration()
   * @generated
   */
  int DECLARATION = 2;

  /**
   * The feature id for the '<em><b>Pattern</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATION__PATTERN = WRESL_EVALUATOR__PATTERN;

  /**
   * The feature id for the '<em><b>Ifincitem</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATION__IFINCITEM = WRESL_EVALUATOR__IFINCITEM;

  /**
   * The feature id for the '<em><b>Initial</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATION__INITIAL = WRESL_EVALUATOR__INITIAL;

  /**
   * The feature id for the '<em><b>Sequence</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATION__SEQUENCE = WRESL_EVALUATOR__SEQUENCE;

  /**
   * The feature id for the '<em><b>Model</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATION__MODEL = WRESL_EVALUATOR__MODEL;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATION__NAME = WRESL_EVALUATOR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATION_FEATURE_COUNT = WRESL_EVALUATOR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link VariableImpl <em>Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see VariableImpl
   * @see WreslEditorPackageImpl#getVariable()
   * @generated
   */
  int VARIABLE = 3;

  /**
   * The feature id for the '<em><b>Local</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__LOCAL = PATTERN__LOCAL;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__REF = PATTERN_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_FEATURE_COUNT = PATTERN_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link StateVariableImpl <em>State Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see StateVariableImpl
   * @see WreslEditorPackageImpl#getStateVariable()
   * @generated
   */
  int STATE_VARIABLE = 4;

  /**
   * The feature id for the '<em><b>Local</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_VARIABLE__LOCAL = VARIABLE__LOCAL;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_VARIABLE__REF = VARIABLE__REF;

  /**
   * The number of structural features of the '<em>State Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_VARIABLE_FEATURE_COUNT = VARIABLE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link DecisionVariableImpl <em>Decision Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see DecisionVariableImpl
   * @see WreslEditorPackageImpl#getDecisionVariable()
   * @generated
   */
  int DECISION_VARIABLE = 5;

  /**
   * The feature id for the '<em><b>Local</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECISION_VARIABLE__LOCAL = VARIABLE__LOCAL;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECISION_VARIABLE__REF = VARIABLE__REF;

  /**
   * The feature id for the '<em><b>Ta</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECISION_VARIABLE__TA = VARIABLE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Decision Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECISION_VARIABLE_FEATURE_COUNT = VARIABLE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link IfIncItemsImpl <em>If Inc Items</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see IfIncItemsImpl
   * @see WreslEditorPackageImpl#getIfIncItems()
   * @generated
   */
  int IF_INC_ITEMS = 6;

  /**
   * The number of structural features of the '<em>If Inc Items</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_INC_ITEMS_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link IfTermImpl <em>If Term</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see IfTermImpl
   * @see WreslEditorPackageImpl#getIfTerm()
   * @generated
   */
  int IF_TERM = 7;

  /**
   * The feature id for the '<em><b>Elseifterm</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_TERM__ELSEIFTERM = IF_INC_ITEMS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Elseterm</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_TERM__ELSETERM = IF_INC_ITEMS_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Logical</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_TERM__LOGICAL = IF_INC_ITEMS_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Pattern</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_TERM__PATTERN = IF_INC_ITEMS_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>If Term</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_TERM_FEATURE_COUNT = IF_INC_ITEMS_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link ElseIfTermImpl <em>Else If Term</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ElseIfTermImpl
   * @see WreslEditorPackageImpl#getElseIfTerm()
   * @generated
   */
  int ELSE_IF_TERM = 8;

  /**
   * The feature id for the '<em><b>Logical</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELSE_IF_TERM__LOGICAL = 0;

  /**
   * The feature id for the '<em><b>Pattern</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELSE_IF_TERM__PATTERN = 1;

  /**
   * The number of structural features of the '<em>Else If Term</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELSE_IF_TERM_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link ElseTermImpl <em>Else Term</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ElseTermImpl
   * @see WreslEditorPackageImpl#getElseTerm()
   * @generated
   */
  int ELSE_TERM = 9;

  /**
   * The feature id for the '<em><b>Pattern</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELSE_TERM__PATTERN = 0;

  /**
   * The number of structural features of the '<em>Else Term</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELSE_TERM_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link TimeArraySizeImpl <em>Time Array Size</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see TimeArraySizeImpl
   * @see WreslEditorPackageImpl#getTimeArraySize()
   * @generated
   */
  int TIME_ARRAY_SIZE = 10;

  /**
   * The feature id for the '<em><b>Name</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_ARRAY_SIZE__NAME = 0;

  /**
   * The number of structural features of the '<em>Time Array Size</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_ARRAY_SIZE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link ObjectiveImpl <em>Objective</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ObjectiveImpl
   * @see WreslEditorPackageImpl#getObjective()
   * @generated
   */
  int OBJECTIVE = 11;

  /**
   * The feature id for the '<em><b>Local</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECTIVE__LOCAL = PATTERN__LOCAL;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECTIVE__NAME = PATTERN_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Weights</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECTIVE__WEIGHTS = PATTERN_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Objective</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECTIVE_FEATURE_COUNT = PATTERN_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link WeightItemImpl <em>Weight Item</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see WeightItemImpl
   * @see WreslEditorPackageImpl#getWeightItem()
   * @generated
   */
  int WEIGHT_ITEM = 12;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WEIGHT_ITEM__REF = 0;

  /**
   * The feature id for the '<em><b>Ta</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WEIGHT_ITEM__TA = 1;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WEIGHT_ITEM__EXPRESSION = 2;

  /**
   * The number of structural features of the '<em>Weight Item</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WEIGHT_ITEM_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link ExternalDefImpl <em>External Def</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ExternalDefImpl
   * @see WreslEditorPackageImpl#getExternalDef()
   * @generated
   */
  int EXTERNAL_DEF = 13;

  /**
   * The feature id for the '<em><b>Local</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_DEF__LOCAL = VARIABLE__LOCAL;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_DEF__REF = VARIABLE__REF;

  /**
   * The feature id for the '<em><b>Definition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_DEF__DEFINITION = VARIABLE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>External Def</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_DEF_FEATURE_COUNT = VARIABLE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link SvarDefImpl <em>Svar Def</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see SvarDefImpl
   * @see WreslEditorPackageImpl#getSvarDef()
   * @generated
   */
  int SVAR_DEF = 14;

  /**
   * The feature id for the '<em><b>Local</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SVAR_DEF__LOCAL = STATE_VARIABLE__LOCAL;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SVAR_DEF__REF = STATE_VARIABLE__REF;

  /**
   * The feature id for the '<em><b>Ta</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SVAR_DEF__TA = STATE_VARIABLE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Definition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SVAR_DEF__DEFINITION = STATE_VARIABLE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Svar Def</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SVAR_DEF_FEATURE_COUNT = STATE_VARIABLE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link DvarDefImpl <em>Dvar Def</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see DvarDefImpl
   * @see WreslEditorPackageImpl#getDvarDef()
   * @generated
   */
  int DVAR_DEF = 15;

  /**
   * The feature id for the '<em><b>Local</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DVAR_DEF__LOCAL = DECISION_VARIABLE__LOCAL;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DVAR_DEF__REF = DECISION_VARIABLE__REF;

  /**
   * The feature id for the '<em><b>Ta</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DVAR_DEF__TA = DECISION_VARIABLE__TA;

  /**
   * The feature id for the '<em><b>Definition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DVAR_DEF__DEFINITION = DECISION_VARIABLE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Dvar Def</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DVAR_DEF_FEATURE_COUNT = DECISION_VARIABLE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link ConstDefImpl <em>Const Def</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ConstDefImpl
   * @see WreslEditorPackageImpl#getConstDef()
   * @generated
   */
  int CONST_DEF = 16;

  /**
   * The feature id for the '<em><b>Local</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONST_DEF__LOCAL = STATE_VARIABLE__LOCAL;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONST_DEF__REF = STATE_VARIABLE__REF;

  /**
   * The feature id for the '<em><b>Definition</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONST_DEF__DEFINITION = STATE_VARIABLE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Const Def</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONST_DEF_FEATURE_COUNT = STATE_VARIABLE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link AliasImpl <em>Alias</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see AliasImpl
   * @see WreslEditorPackageImpl#getAlias()
   * @generated
   */
  int ALIAS = 17;

  /**
   * The feature id for the '<em><b>Local</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALIAS__LOCAL = DECISION_VARIABLE__LOCAL;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALIAS__REF = DECISION_VARIABLE__REF;

  /**
   * The feature id for the '<em><b>Ta</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALIAS__TA = DECISION_VARIABLE__TA;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALIAS__EXPRESSION = DECISION_VARIABLE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALIAS__KIND = DECISION_VARIABLE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Units</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALIAS__UNITS = DECISION_VARIABLE_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Alias</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALIAS_FEATURE_COUNT = DECISION_VARIABLE_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link ExternalImpl <em>External</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ExternalImpl
   * @see WreslEditorPackageImpl#getExternal()
   * @generated
   */
  int EXTERNAL = 18;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL__NAME = 0;

  /**
   * The number of structural features of the '<em>External</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link DVarImpl <em>DVar</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see DVarImpl
   * @see WreslEditorPackageImpl#getDVar()
   * @generated
   */
  int DVAR = 19;

  /**
   * The feature id for the '<em><b>Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DVAR__KIND = 0;

  /**
   * The feature id for the '<em><b>Units</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DVAR__UNITS = 1;

  /**
   * The number of structural features of the '<em>DVar</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DVAR_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link DVarNonStdImpl <em>DVar Non Std</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see DVarNonStdImpl
   * @see WreslEditorPackageImpl#getDVarNonStd()
   * @generated
   */
  int DVAR_NON_STD = 20;

  /**
   * The feature id for the '<em><b>Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DVAR_NON_STD__KIND = DVAR__KIND;

  /**
   * The feature id for the '<em><b>Units</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DVAR_NON_STD__UNITS = DVAR__UNITS;

  /**
   * The feature id for the '<em><b>Lower Upper</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DVAR_NON_STD__LOWER_UPPER = DVAR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>DVar Non Std</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DVAR_NON_STD_FEATURE_COUNT = DVAR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link DVarStdImpl <em>DVar Std</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see DVarStdImpl
   * @see WreslEditorPackageImpl#getDVarStd()
   * @generated
   */
  int DVAR_STD = 21;

  /**
   * The feature id for the '<em><b>Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DVAR_STD__KIND = DVAR__KIND;

  /**
   * The feature id for the '<em><b>Units</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DVAR_STD__UNITS = DVAR__UNITS;

  /**
   * The number of structural features of the '<em>DVar Std</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DVAR_STD_FEATURE_COUNT = DVAR_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link DVarIntegerImpl <em>DVar Integer</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see DVarIntegerImpl
   * @see WreslEditorPackageImpl#getDVarInteger()
   * @generated
   */
  int DVAR_INTEGER = 22;

  /**
   * The number of structural features of the '<em>DVar Integer</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DVAR_INTEGER_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link DVarIntegerStdImpl <em>DVar Integer Std</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see DVarIntegerStdImpl
   * @see WreslEditorPackageImpl#getDVarIntegerStd()
   * @generated
   */
  int DVAR_INTEGER_STD = 23;

  /**
   * The feature id for the '<em><b>Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DVAR_INTEGER_STD__KIND = DVAR_INTEGER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Units</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DVAR_INTEGER_STD__UNITS = DVAR_INTEGER_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>DVar Integer Std</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DVAR_INTEGER_STD_FEATURE_COUNT = DVAR_INTEGER_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link DVarIntegerNonStdImpl <em>DVar Integer Non Std</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see DVarIntegerNonStdImpl
   * @see WreslEditorPackageImpl#getDVarIntegerNonStd()
   * @generated
   */
  int DVAR_INTEGER_NON_STD = 24;

  /**
   * The number of structural features of the '<em>DVar Integer Non Std</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DVAR_INTEGER_NON_STD_FEATURE_COUNT = DVAR_INTEGER_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link SVarImpl <em>SVar</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see SVarImpl
   * @see WreslEditorPackageImpl#getSVar()
   * @generated
   */
  int SVAR = 25;

  /**
   * The number of structural features of the '<em>SVar</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SVAR_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link SVarDSSImpl <em>SVar DSS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see SVarDSSImpl
   * @see WreslEditorPackageImpl#getSVarDSS()
   * @generated
   */
  int SVAR_DSS = 26;

  /**
   * The feature id for the '<em><b>BPart</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SVAR_DSS__BPART = SVAR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SVAR_DSS__KIND = SVAR_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Units</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SVAR_DSS__UNITS = SVAR_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Convert</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SVAR_DSS__CONVERT = SVAR_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>SVar DSS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SVAR_DSS_FEATURE_COUNT = SVAR_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link SVarExpressionImpl <em>SVar Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see SVarExpressionImpl
   * @see WreslEditorPackageImpl#getSVarExpression()
   * @generated
   */
  int SVAR_EXPRESSION = 27;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SVAR_EXPRESSION__EXPRESSION = SVAR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>SVar Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SVAR_EXPRESSION_FEATURE_COUNT = SVAR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link SVarSumImpl <em>SVar Sum</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see SVarSumImpl
   * @see WreslEditorPackageImpl#getSVarSum()
   * @generated
   */
  int SVAR_SUM = 28;

  /**
   * The feature id for the '<em><b>Sum Content</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SVAR_SUM__SUM_CONTENT = SVAR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>SVar Sum</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SVAR_SUM_FEATURE_COUNT = SVAR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link SVarTableImpl <em>SVar Table</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see SVarTableImpl
   * @see WreslEditorPackageImpl#getSVarTable()
   * @generated
   */
  int SVAR_TABLE = 29;

  /**
   * The feature id for the '<em><b>Table Content</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SVAR_TABLE__TABLE_CONTENT = SVAR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>SVar Table</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SVAR_TABLE_FEATURE_COUNT = SVAR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link SVarCaseImpl <em>SVar Case</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see SVarCaseImpl
   * @see WreslEditorPackageImpl#getSVarCase()
   * @generated
   */
  int SVAR_CASE = 30;

  /**
   * The feature id for the '<em><b>Case Content</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SVAR_CASE__CASE_CONTENT = SVAR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>SVar Case</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SVAR_CASE_FEATURE_COUNT = SVAR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link CaseContentImpl <em>Case Content</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see CaseContentImpl
   * @see WreslEditorPackageImpl#getCaseContent()
   * @generated
   */
  int CASE_CONTENT = 31;

  /**
   * The feature id for the '<em><b>Case Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_CONTENT__CASE_NAME = 0;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_CONTENT__CONDITION = 1;

  /**
   * The feature id for the '<em><b>Content</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_CONTENT__CONTENT = 2;

  /**
   * The number of structural features of the '<em>Case Content</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_CONTENT_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link TermSimpleImpl <em>Term Simple</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see TermSimpleImpl
   * @see WreslEditorPackageImpl#getTermSimple()
   * @generated
   */
  int TERM_SIMPLE = 38;

  /**
   * The number of structural features of the '<em>Term Simple</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TERM_SIMPLE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link FunctionImpl <em>Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see FunctionImpl
   * @see WreslEditorPackageImpl#getFunction()
   * @generated
   */
  int FUNCTION = 67;

  /**
   * The number of structural features of the '<em>Function</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_FEATURE_COUNT = TERM_SIMPLE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link SumContentImpl <em>Sum Content</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see SumContentImpl
   * @see WreslEditorPackageImpl#getSumContent()
   * @generated
   */
  int SUM_CONTENT = 32;

  /**
   * The feature id for the '<em><b>Header</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUM_CONTENT__HEADER = FUNCTION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUM_CONTENT__EXPRESSION = FUNCTION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Sum Content</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUM_CONTENT_FEATURE_COUNT = FUNCTION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link SumHeaderImpl <em>Sum Header</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see SumHeaderImpl
   * @see WreslEditorPackageImpl#getSumHeader()
   * @generated
   */
  int SUM_HEADER = 33;

  /**
   * The feature id for the '<em><b>Expression1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUM_HEADER__EXPRESSION1 = 0;

  /**
   * The feature id for the '<em><b>Expression2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUM_HEADER__EXPRESSION2 = 1;

  /**
   * The number of structural features of the '<em>Sum Header</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUM_HEADER_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link ValueContentImpl <em>Value Content</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ValueContentImpl
   * @see WreslEditorPackageImpl#getValueContent()
   * @generated
   */
  int VALUE_CONTENT = 34;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_CONTENT__EXPRESSION = 0;

  /**
   * The number of structural features of the '<em>Value Content</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_CONTENT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link TableContentImpl <em>Table Content</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see TableContentImpl
   * @see WreslEditorPackageImpl#getTableContent()
   * @generated
   */
  int TABLE_CONTENT = 35;

  /**
   * The feature id for the '<em><b>Table Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_CONTENT__TABLE_NAME = 0;

  /**
   * The feature id for the '<em><b>From</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_CONTENT__FROM = 1;

  /**
   * The feature id for the '<em><b>Given</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_CONTENT__GIVEN = 2;

  /**
   * The feature id for the '<em><b>Use</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_CONTENT__USE = 3;

  /**
   * The feature id for the '<em><b>Where</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_CONTENT__WHERE = 4;

  /**
   * The number of structural features of the '<em>Table Content</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_CONTENT_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link WhereItemsImpl <em>Where Items</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see WhereItemsImpl
   * @see WreslEditorPackageImpl#getWhereItems()
   * @generated
   */
  int WHERE_ITEMS = 36;

  /**
   * The feature id for the '<em><b>Assignment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHERE_ITEMS__ASSIGNMENT = 0;

  /**
   * The number of structural features of the '<em>Where Items</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHERE_ITEMS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link AssignmentImpl <em>Assignment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see AssignmentImpl
   * @see WreslEditorPackageImpl#getAssignment()
   * @generated
   */
  int ASSIGNMENT = 37;

  /**
   * The feature id for the '<em><b>Term</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT__TERM = 0;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT__EXPRESSION = 1;

  /**
   * The number of structural features of the '<em>Assignment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link LowerAndOrUpperImpl <em>Lower And Or Upper</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see LowerAndOrUpperImpl
   * @see WreslEditorPackageImpl#getLowerAndOrUpper()
   * @generated
   */
  int LOWER_AND_OR_UPPER = 39;

  /**
   * The feature id for the '<em><b>Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOWER_AND_OR_UPPER__KIND = DVAR_INTEGER_NON_STD_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Units</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOWER_AND_OR_UPPER__UNITS = DVAR_INTEGER_NON_STD_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Upper</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOWER_AND_OR_UPPER__UPPER = DVAR_INTEGER_NON_STD_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Lower</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOWER_AND_OR_UPPER__LOWER = DVAR_INTEGER_NON_STD_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Lower And Or Upper</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOWER_AND_OR_UPPER_FEATURE_COUNT = DVAR_INTEGER_NON_STD_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link upperLowerImpl <em>upper Lower</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see upperLowerImpl
   * @see WreslEditorPackageImpl#getupperLower()
   * @generated
   */
  int UPPER_LOWER = 40;

  /**
   * The feature id for the '<em><b>Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UPPER_LOWER__KIND = LOWER_AND_OR_UPPER__KIND;

  /**
   * The feature id for the '<em><b>Units</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UPPER_LOWER__UNITS = LOWER_AND_OR_UPPER__UNITS;

  /**
   * The feature id for the '<em><b>Upper</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UPPER_LOWER__UPPER = LOWER_AND_OR_UPPER__UPPER;

  /**
   * The feature id for the '<em><b>Lower</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UPPER_LOWER__LOWER = LOWER_AND_OR_UPPER__LOWER;

  /**
   * The number of structural features of the '<em>upper Lower</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UPPER_LOWER_FEATURE_COUNT = LOWER_AND_OR_UPPER_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link lowerUpperImpl <em>lower Upper</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see lowerUpperImpl
   * @see WreslEditorPackageImpl#getlowerUpper()
   * @generated
   */
  int LOWER_UPPER = 41;

  /**
   * The feature id for the '<em><b>Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOWER_UPPER__KIND = LOWER_AND_OR_UPPER__KIND;

  /**
   * The feature id for the '<em><b>Units</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOWER_UPPER__UNITS = LOWER_AND_OR_UPPER__UNITS;

  /**
   * The feature id for the '<em><b>Upper</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOWER_UPPER__UPPER = LOWER_AND_OR_UPPER__UPPER;

  /**
   * The feature id for the '<em><b>Lower</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOWER_UPPER__LOWER = LOWER_AND_OR_UPPER__LOWER;

  /**
   * The number of structural features of the '<em>lower Upper</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOWER_UPPER_FEATURE_COUNT = LOWER_AND_OR_UPPER_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link UpperImpl <em>Upper</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see UpperImpl
   * @see WreslEditorPackageImpl#getUpper()
   * @generated
   */
  int UPPER = 42;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UPPER__EXPRESSION = 0;

  /**
   * The number of structural features of the '<em>Upper</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UPPER_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link LowerImpl <em>Lower</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see LowerImpl
   * @see WreslEditorPackageImpl#getLower()
   * @generated
   */
  int LOWER = 43;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOWER__EXPRESSION = 0;

  /**
   * The number of structural features of the '<em>Lower</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOWER_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link GoalImpl <em>Goal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see GoalImpl
   * @see WreslEditorPackageImpl#getGoal()
   * @generated
   */
  int GOAL = 44;

  /**
   * The feature id for the '<em><b>Local</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__LOCAL = PATTERN__LOCAL;

  /**
   * The feature id for the '<em><b>Ta</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__TA = PATTERN_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__NAME = PATTERN_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Definition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__DEFINITION = PATTERN_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Goal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL_FEATURE_COUNT = PATTERN_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link GoalCaseImpl <em>Goal Case</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see GoalCaseImpl
   * @see WreslEditorPackageImpl#getGoalCase()
   * @generated
   */
  int GOAL_CASE = 45;

  /**
   * The feature id for the '<em><b>Lhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL_CASE__LHS = 0;

  /**
   * The feature id for the '<em><b>Content</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL_CASE__CONTENT = 1;

  /**
   * The feature id for the '<em><b>Case Content</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL_CASE__CASE_CONTENT = 2;

  /**
   * The number of structural features of the '<em>Goal Case</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL_CASE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link GoalCaseContentImpl <em>Goal Case Content</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see GoalCaseContentImpl
   * @see WreslEditorPackageImpl#getGoalCaseContent()
   * @generated
   */
  int GOAL_CASE_CONTENT = 46;

  /**
   * The feature id for the '<em><b>Case Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL_CASE_CONTENT__CASE_NAME = 0;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL_CASE_CONTENT__CONDITION = 1;

  /**
   * The feature id for the '<em><b>Rhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL_CASE_CONTENT__RHS = 2;

  /**
   * The feature id for the '<em><b>Sub Content</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL_CASE_CONTENT__SUB_CONTENT = 3;

  /**
   * The number of structural features of the '<em>Goal Case Content</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL_CASE_CONTENT_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link GoalNoCaseContentImpl <em>Goal No Case Content</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see GoalNoCaseContentImpl
   * @see WreslEditorPackageImpl#getGoalNoCaseContent()
   * @generated
   */
  int GOAL_NO_CASE_CONTENT = 47;

  /**
   * The feature id for the '<em><b>Rhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL_NO_CASE_CONTENT__RHS = 0;

  /**
   * The feature id for the '<em><b>Sub Content</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL_NO_CASE_CONTENT__SUB_CONTENT = 1;

  /**
   * The number of structural features of the '<em>Goal No Case Content</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL_NO_CASE_CONTENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link SubContentImpl <em>Sub Content</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see SubContentImpl
   * @see WreslEditorPackageImpl#getSubContent()
   * @generated
   */
  int SUB_CONTENT = 48;

  /**
   * The feature id for the '<em><b>Gt</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_CONTENT__GT = 0;

  /**
   * The feature id for the '<em><b>Lt</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_CONTENT__LT = 1;

  /**
   * The number of structural features of the '<em>Sub Content</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_CONTENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link LhsGtRhsImpl <em>Lhs Gt Rhs</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see LhsGtRhsImpl
   * @see WreslEditorPackageImpl#getLhsGtRhs()
   * @generated
   */
  int LHS_GT_RHS = 49;

  /**
   * The feature id for the '<em><b>Penalty</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LHS_GT_RHS__PENALTY = 0;

  /**
   * The number of structural features of the '<em>Lhs Gt Rhs</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LHS_GT_RHS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link LhsLtRhsImpl <em>Lhs Lt Rhs</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see LhsLtRhsImpl
   * @see WreslEditorPackageImpl#getLhsLtRhs()
   * @generated
   */
  int LHS_LT_RHS = 50;

  /**
   * The feature id for the '<em><b>Penalty</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LHS_LT_RHS__PENALTY = 0;

  /**
   * The number of structural features of the '<em>Lhs Lt Rhs</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LHS_LT_RHS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link PenaltyImpl <em>Penalty</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PenaltyImpl
   * @see WreslEditorPackageImpl#getPenalty()
   * @generated
   */
  int PENALTY = 51;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PENALTY__EXPRESSION = 0;

  /**
   * The number of structural features of the '<em>Penalty</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PENALTY_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link GoalSimpleImpl <em>Goal Simple</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see GoalSimpleImpl
   * @see WreslEditorPackageImpl#getGoalSimple()
   * @generated
   */
  int GOAL_SIMPLE = 52;

  /**
   * The feature id for the '<em><b>Constraint</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL_SIMPLE__CONSTRAINT = 0;

  /**
   * The number of structural features of the '<em>Goal Simple</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL_SIMPLE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link ConstraintImpl <em>Constraint</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ConstraintImpl
   * @see WreslEditorPackageImpl#getConstraint()
   * @generated
   */
  int CONSTRAINT = 53;

  /**
   * The feature id for the '<em><b>Lhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT__LHS = 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT__OPERATOR = 1;

  /**
   * The feature id for the '<em><b>Rhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT__RHS = 2;

  /**
   * The number of structural features of the '<em>Constraint</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link GroupImpl <em>Group</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see GroupImpl
   * @see WreslEditorPackageImpl#getGroup()
   * @generated
   */
  int GROUP = 54;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUP__NAME = 0;

  /**
   * The feature id for the '<em><b>Pattern</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUP__PATTERN = 1;

  /**
   * The feature id for the '<em><b>Ifincitems</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUP__IFINCITEMS = 2;

  /**
   * The number of structural features of the '<em>Group</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUP_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ModelImpl
   * @see WreslEditorPackageImpl#getModel()
   * @generated
   */
  int MODEL = 55;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__NAME = 0;

  /**
   * The feature id for the '<em><b>Pattern</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__PATTERN = 1;

  /**
   * The feature id for the '<em><b>Ifincitems</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__IFINCITEMS = 2;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link InitialImpl <em>Initial</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see InitialImpl
   * @see WreslEditorPackageImpl#getInitial()
   * @generated
   */
  int INITIAL = 56;

  /**
   * The feature id for the '<em><b>Pattern</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INITIAL__PATTERN = 0;

  /**
   * The number of structural features of the '<em>Initial</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INITIAL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link SequenceImpl <em>Sequence</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see SequenceImpl
   * @see WreslEditorPackageImpl#getSequence()
   * @generated
   */
  int SEQUENCE = 57;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEQUENCE__NAME = 0;

  /**
   * The feature id for the '<em><b>Model</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEQUENCE__MODEL = 1;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEQUENCE__CONDITION = 2;

  /**
   * The feature id for the '<em><b>Order</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEQUENCE__ORDER = 3;

  /**
   * The number of structural features of the '<em>Sequence</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEQUENCE_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link ConditionImpl <em>Condition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ConditionImpl
   * @see WreslEditorPackageImpl#getCondition()
   * @generated
   */
  int CONDITION = 58;

  /**
   * The feature id for the '<em><b>Logical</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITION__LOGICAL = 0;

  /**
   * The number of structural features of the '<em>Condition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link ConditionalUnaryImpl <em>Conditional Unary</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ConditionalUnaryImpl
   * @see WreslEditorPackageImpl#getConditionalUnary()
   * @generated
   */
  int CONDITIONAL_UNARY = 60;

  /**
   * The number of structural features of the '<em>Conditional Unary</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_UNARY_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link ConditionalTermImpl <em>Conditional Term</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ConditionalTermImpl
   * @see WreslEditorPackageImpl#getConditionalTerm()
   * @generated
   */
  int CONDITIONAL_TERM = 61;

  /**
   * The feature id for the '<em><b>E1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_TERM__E1 = CONDITIONAL_UNARY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>E2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_TERM__E2 = CONDITIONAL_UNARY_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Conditional Term</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_TERM_FEATURE_COUNT = CONDITIONAL_UNARY_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link LogicalExpressionImpl <em>Logical Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see LogicalExpressionImpl
   * @see WreslEditorPackageImpl#getLogicalExpression()
   * @generated
   */
  int LOGICAL_EXPRESSION = 59;

  /**
   * The feature id for the '<em><b>E1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_EXPRESSION__E1 = CONDITIONAL_TERM__E1;

  /**
   * The feature id for the '<em><b>E2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_EXPRESSION__E2 = CONDITIONAL_TERM__E2;

  /**
   * The feature id for the '<em><b>C1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_EXPRESSION__C1 = CONDITIONAL_TERM_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>C2</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_EXPRESSION__C2 = CONDITIONAL_TERM_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Logical Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_EXPRESSION_FEATURE_COUNT = CONDITIONAL_TERM_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ExpressionImpl
   * @see WreslEditorPackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 62;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link AddImpl <em>Add</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see AddImpl
   * @see WreslEditorPackageImpl#getAdd()
   * @generated
   */
  int ADD = 63;

  /**
   * The feature id for the '<em><b>M1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADD__M1 = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>M2</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADD__M2 = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Add</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADD_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link MultiplyImpl <em>Multiply</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see MultiplyImpl
   * @see WreslEditorPackageImpl#getMultiply()
   * @generated
   */
  int MULTIPLY = 64;

  /**
   * The feature id for the '<em><b>U1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLY__U1 = 0;

  /**
   * The feature id for the '<em><b>U2</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLY__U2 = 1;

  /**
   * The number of structural features of the '<em>Multiply</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLY_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link UnaryImpl <em>Unary</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see UnaryImpl
   * @see WreslEditorPackageImpl#getUnary()
   * @generated
   */
  int UNARY = 65;

  /**
   * The number of structural features of the '<em>Unary</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link TermImpl <em>Term</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see TermImpl
   * @see WreslEditorPackageImpl#getTerm()
   * @generated
   */
  int TERM = 66;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TERM__REF = UNARY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>N</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TERM__N = UNARY_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>F</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TERM__F = UNARY_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>E</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TERM__E = UNARY_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>S</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TERM__S = UNARY_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Term</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TERM_FEATURE_COUNT = UNARY_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link ExternalFunction1Impl <em>External Function1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ExternalFunction1Impl
   * @see WreslEditorPackageImpl#getExternalFunction1()
   * @generated
   */
  int EXTERNAL_FUNCTION1 = 68;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_FUNCTION1__REF = FUNCTION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>E1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_FUNCTION1__E1 = FUNCTION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>E2</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_FUNCTION1__E2 = FUNCTION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>E0</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_FUNCTION1__E0 = FUNCTION_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>External Function1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_FUNCTION1_FEATURE_COUNT = FUNCTION_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link ExternalFunction2Impl <em>External Function2</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ExternalFunction2Impl
   * @see WreslEditorPackageImpl#getExternalFunction2()
   * @generated
   */
  int EXTERNAL_FUNCTION2 = 69;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_FUNCTION2__REF = FUNCTION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>External Function2</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_FUNCTION2_FEATURE_COUNT = FUNCTION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link TrunkTimeArrayImpl <em>Trunk Time Array</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see TrunkTimeArrayImpl
   * @see WreslEditorPackageImpl#getTrunkTimeArray()
   * @generated
   */
  int TRUNK_TIME_ARRAY = 70;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRUNK_TIME_ARRAY__REF = 0;

  /**
   * The feature id for the '<em><b>T1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRUNK_TIME_ARRAY__T1 = 1;

  /**
   * The feature id for the '<em><b>T2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRUNK_TIME_ARRAY__T2 = 2;

  /**
   * The number of structural features of the '<em>Trunk Time Array</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRUNK_TIME_ARRAY_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link TrunkTimeArrayIndexImpl <em>Trunk Time Array Index</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see TrunkTimeArrayIndexImpl
   * @see WreslEditorPackageImpl#getTrunkTimeArrayIndex()
   * @generated
   */
  int TRUNK_TIME_ARRAY_INDEX = 71;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRUNK_TIME_ARRAY_INDEX__REF = 0;

  /**
   * The number of structural features of the '<em>Trunk Time Array Index</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRUNK_TIME_ARRAY_INDEX_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link MaxFunctionImpl <em>Max Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see MaxFunctionImpl
   * @see WreslEditorPackageImpl#getMaxFunction()
   * @generated
   */
  int MAX_FUNCTION = 72;

  /**
   * The feature id for the '<em><b>E1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAX_FUNCTION__E1 = FUNCTION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>E2</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAX_FUNCTION__E2 = FUNCTION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Max Function</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAX_FUNCTION_FEATURE_COUNT = FUNCTION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link MinFunctionImpl <em>Min Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see MinFunctionImpl
   * @see WreslEditorPackageImpl#getMinFunction()
   * @generated
   */
  int MIN_FUNCTION = 73;

  /**
   * The feature id for the '<em><b>E1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MIN_FUNCTION__E1 = FUNCTION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>E2</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MIN_FUNCTION__E2 = FUNCTION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Min Function</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MIN_FUNCTION_FEATURE_COUNT = FUNCTION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link ModFunctionImpl <em>Mod Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ModFunctionImpl
   * @see WreslEditorPackageImpl#getModFunction()
   * @generated
   */
  int MOD_FUNCTION = 74;

  /**
   * The feature id for the '<em><b>E1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MOD_FUNCTION__E1 = FUNCTION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>E2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MOD_FUNCTION__E2 = FUNCTION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Mod Function</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MOD_FUNCTION_FEATURE_COUNT = FUNCTION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link IntFunctionImpl <em>Int Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see IntFunctionImpl
   * @see WreslEditorPackageImpl#getIntFunction()
   * @generated
   */
  int INT_FUNCTION = 75;

  /**
   * The feature id for the '<em><b>E</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_FUNCTION__E = FUNCTION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Int Function</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_FUNCTION_FEATURE_COUNT = FUNCTION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link AbsFunctionImpl <em>Abs Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see AbsFunctionImpl
   * @see WreslEditorPackageImpl#getAbsFunction()
   * @generated
   */
  int ABS_FUNCTION = 76;

  /**
   * The feature id for the '<em><b>E</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABS_FUNCTION__E = FUNCTION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Abs Function</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABS_FUNCTION_FEATURE_COUNT = FUNCTION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link RoundFunctionImpl <em>Round Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see RoundFunctionImpl
   * @see WreslEditorPackageImpl#getRoundFunction()
   * @generated
   */
  int ROUND_FUNCTION = 77;

  /**
   * The feature id for the '<em><b>E</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROUND_FUNCTION__E = FUNCTION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Round Function</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROUND_FUNCTION_FEATURE_COUNT = FUNCTION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link PowFunctionImpl <em>Pow Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PowFunctionImpl
   * @see WreslEditorPackageImpl#getPowFunction()
   * @generated
   */
  int POW_FUNCTION = 78;

  /**
   * The feature id for the '<em><b>E1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POW_FUNCTION__E1 = FUNCTION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>E2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POW_FUNCTION__E2 = FUNCTION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Pow Function</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POW_FUNCTION_FEATURE_COUNT = FUNCTION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link LogFunctionImpl <em>Log Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see LogFunctionImpl
   * @see WreslEditorPackageImpl#getLogFunction()
   * @generated
   */
  int LOG_FUNCTION = 79;

  /**
   * The feature id for the '<em><b>E</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOG_FUNCTION__E = FUNCTION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Log Function</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOG_FUNCTION_FEATURE_COUNT = FUNCTION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link SinFunctionImpl <em>Sin Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see SinFunctionImpl
   * @see WreslEditorPackageImpl#getSinFunction()
   * @generated
   */
  int SIN_FUNCTION = 80;

  /**
   * The feature id for the '<em><b>E</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIN_FUNCTION__E = FUNCTION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Sin Function</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIN_FUNCTION_FEATURE_COUNT = FUNCTION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link CosFunctionImpl <em>Cos Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see CosFunctionImpl
   * @see WreslEditorPackageImpl#getCosFunction()
   * @generated
   */
  int COS_FUNCTION = 81;

  /**
   * The feature id for the '<em><b>E</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COS_FUNCTION__E = FUNCTION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Cos Function</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COS_FUNCTION_FEATURE_COUNT = FUNCTION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link TanFunctionImpl <em>Tan Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see TanFunctionImpl
   * @see WreslEditorPackageImpl#getTanFunction()
   * @generated
   */
  int TAN_FUNCTION = 82;

  /**
   * The feature id for the '<em><b>E</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TAN_FUNCTION__E = FUNCTION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Tan Function</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TAN_FUNCTION_FEATURE_COUNT = FUNCTION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link CotFunctionImpl <em>Cot Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see CotFunctionImpl
   * @see WreslEditorPackageImpl#getCotFunction()
   * @generated
   */
  int COT_FUNCTION = 83;

  /**
   * The feature id for the '<em><b>E</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COT_FUNCTION__E = FUNCTION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Cot Function</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COT_FUNCTION_FEATURE_COUNT = FUNCTION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link AsinFunctionImpl <em>Asin Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see AsinFunctionImpl
   * @see WreslEditorPackageImpl#getAsinFunction()
   * @generated
   */
  int ASIN_FUNCTION = 84;

  /**
   * The feature id for the '<em><b>E</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASIN_FUNCTION__E = FUNCTION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Asin Function</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASIN_FUNCTION_FEATURE_COUNT = FUNCTION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link AcosFunctionImpl <em>Acos Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see AcosFunctionImpl
   * @see WreslEditorPackageImpl#getAcosFunction()
   * @generated
   */
  int ACOS_FUNCTION = 85;

  /**
   * The feature id for the '<em><b>E</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACOS_FUNCTION__E = FUNCTION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Acos Function</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACOS_FUNCTION_FEATURE_COUNT = FUNCTION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link AtanFunctionImpl <em>Atan Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see AtanFunctionImpl
   * @see WreslEditorPackageImpl#getAtanFunction()
   * @generated
   */
  int ATAN_FUNCTION = 86;

  /**
   * The feature id for the '<em><b>E</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATAN_FUNCTION__E = FUNCTION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Atan Function</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATAN_FUNCTION_FEATURE_COUNT = FUNCTION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link AcotFunctionImpl <em>Acot Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see AcotFunctionImpl
   * @see WreslEditorPackageImpl#getAcotFunction()
   * @generated
   */
  int ACOT_FUNCTION = 87;

  /**
   * The feature id for the '<em><b>E</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACOT_FUNCTION__E = FUNCTION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Acot Function</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACOT_FUNCTION_FEATURE_COUNT = FUNCTION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link VarModelImpl <em>Var Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see VarModelImpl
   * @see WreslEditorPackageImpl#getVarModel()
   * @generated
   */
  int VAR_MODEL = 88;

  /**
   * The feature id for the '<em><b>Ref1</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_MODEL__REF1 = FUNCTION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Ref2</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_MODEL__REF2 = FUNCTION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Var Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_MODEL_FEATURE_COUNT = FUNCTION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link VarModelStepImpl <em>Var Model Step</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see VarModelStepImpl
   * @see WreslEditorPackageImpl#getVarModelStep()
   * @generated
   */
  int VAR_MODEL_STEP = 89;

  /**
   * The feature id for the '<em><b>Ref1</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_MODEL_STEP__REF1 = FUNCTION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Ref2</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_MODEL_STEP__REF2 = FUNCTION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>E</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_MODEL_STEP__E = FUNCTION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Var Model Step</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_MODEL_STEP_FEATURE_COUNT = FUNCTION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link VarModelIndexImpl <em>Var Model Index</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see VarModelIndexImpl
   * @see WreslEditorPackageImpl#getVarModelIndex()
   * @generated
   */
  int VAR_MODEL_INDEX = 90;

  /**
   * The feature id for the '<em><b>Ref1</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_MODEL_INDEX__REF1 = FUNCTION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Var Model Index</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_MODEL_INDEX_FEATURE_COUNT = FUNCTION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link VarModelIndexStepImpl <em>Var Model Index Step</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see VarModelIndexStepImpl
   * @see WreslEditorPackageImpl#getVarModelIndexStep()
   * @generated
   */
  int VAR_MODEL_INDEX_STEP = 91;

  /**
   * The feature id for the '<em><b>Ref1</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_MODEL_INDEX_STEP__REF1 = FUNCTION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>E</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_MODEL_INDEX_STEP__E = FUNCTION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Var Model Index Step</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_MODEL_INDEX_STEP_FEATURE_COUNT = FUNCTION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link IdentImpl <em>Ident</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see IdentImpl
   * @see WreslEditorPackageImpl#getIdent()
   * @generated
   */
  int IDENT = 92;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IDENT__NAME = 0;

  /**
   * The number of structural features of the '<em>Ident</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IDENT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link IncludeFileImpl <em>Include File</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see IncludeFileImpl
   * @see WreslEditorPackageImpl#getIncludeFile()
   * @generated
   */
  int INCLUDE_FILE = 93;

  /**
   * The feature id for the '<em><b>Local</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INCLUDE_FILE__LOCAL = PATTERN__LOCAL;

  /**
   * The feature id for the '<em><b>File</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INCLUDE_FILE__FILE = PATTERN_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Include File</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INCLUDE_FILE_FEATURE_COUNT = PATTERN_FEATURE_COUNT + 1;


  /**
   * Returns the meta object for class '{@link WreslEvaluator <em>Wresl Evaluator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Wresl Evaluator</em>'.
   * @see WreslEvaluator
   * @generated
   */
  EClass getWreslEvaluator();

  /**
   * Returns the meta object for the containment reference list '{@link WreslEvaluator#getPattern <em>Pattern</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Pattern</em>'.
   * @see WreslEvaluator#getPattern()
   * @see #getWreslEvaluator()
   * @generated
   */
  EReference getWreslEvaluator_Pattern();

  /**
   * Returns the meta object for the containment reference list '{@link WreslEvaluator#getIfincitem <em>Ifincitem</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Ifincitem</em>'.
   * @see WreslEvaluator#getIfincitem()
   * @see #getWreslEvaluator()
   * @generated
   */
  EReference getWreslEvaluator_Ifincitem();

  /**
   * Returns the meta object for the containment reference '{@link WreslEvaluator#getInitial <em>Initial</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Initial</em>'.
   * @see WreslEvaluator#getInitial()
   * @see #getWreslEvaluator()
   * @generated
   */
  EReference getWreslEvaluator_Initial();

  /**
   * Returns the meta object for the containment reference list '{@link WreslEvaluator#getSequence <em>Sequence</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Sequence</em>'.
   * @see WreslEvaluator#getSequence()
   * @see #getWreslEvaluator()
   * @generated
   */
  EReference getWreslEvaluator_Sequence();

  /**
   * Returns the meta object for the containment reference list '{@link WreslEvaluator#getModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Model</em>'.
   * @see WreslEvaluator#getModel()
   * @see #getWreslEvaluator()
   * @generated
   */
  EReference getWreslEvaluator_Model();

  /**
   * Returns the meta object for class '{@link Pattern <em>Pattern</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Pattern</em>'.
   * @see Pattern
   * @generated
   */
  EClass getPattern();

  /**
   * Returns the meta object for the attribute '{@link Pattern#isLocal <em>Local</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Local</em>'.
   * @see Pattern#isLocal()
   * @see #getPattern()
   * @generated
   */
  EAttribute getPattern_Local();

  /**
   * Returns the meta object for class '{@link Declaration <em>Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Declaration</em>'.
   * @see Declaration
   * @generated
   */
  EClass getDeclaration();

  /**
   * Returns the meta object for the attribute '{@link Declaration#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see Declaration#getName()
   * @see #getDeclaration()
   * @generated
   */
  EAttribute getDeclaration_Name();

  /**
   * Returns the meta object for class '{@link Variable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable</em>'.
   * @see Variable
   * @generated
   */
  EClass getVariable();

  /**
   * Returns the meta object for the reference '{@link Variable#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see Variable#getRef()
   * @see #getVariable()
   * @generated
   */
  EReference getVariable_Ref();

  /**
   * Returns the meta object for class '{@link StateVariable <em>State Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State Variable</em>'.
   * @see StateVariable
   * @generated
   */
  EClass getStateVariable();

  /**
   * Returns the meta object for class '{@link DecisionVariable <em>Decision Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Decision Variable</em>'.
   * @see DecisionVariable
   * @generated
   */
  EClass getDecisionVariable();

  /**
   * Returns the meta object for the containment reference '{@link DecisionVariable#getTa <em>Ta</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Ta</em>'.
   * @see DecisionVariable#getTa()
   * @see #getDecisionVariable()
   * @generated
   */
  EReference getDecisionVariable_Ta();

  /**
   * Returns the meta object for class '{@link IfIncItems <em>If Inc Items</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>If Inc Items</em>'.
   * @see IfIncItems
   * @generated
   */
  EClass getIfIncItems();

  /**
   * Returns the meta object for class '{@link IfTerm <em>If Term</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>If Term</em>'.
   * @see IfTerm
   * @generated
   */
  EClass getIfTerm();

  /**
   * Returns the meta object for the containment reference '{@link IfTerm#getElseifterm <em>Elseifterm</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Elseifterm</em>'.
   * @see IfTerm#getElseifterm()
   * @see #getIfTerm()
   * @generated
   */
  EReference getIfTerm_Elseifterm();

  /**
   * Returns the meta object for the containment reference '{@link IfTerm#getElseterm <em>Elseterm</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Elseterm</em>'.
   * @see IfTerm#getElseterm()
   * @see #getIfTerm()
   * @generated
   */
  EReference getIfTerm_Elseterm();

  /**
   * Returns the meta object for the containment reference '{@link IfTerm#getLogical <em>Logical</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Logical</em>'.
   * @see IfTerm#getLogical()
   * @see #getIfTerm()
   * @generated
   */
  EReference getIfTerm_Logical();

  /**
   * Returns the meta object for the containment reference list '{@link IfTerm#getPattern <em>Pattern</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Pattern</em>'.
   * @see IfTerm#getPattern()
   * @see #getIfTerm()
   * @generated
   */
  EReference getIfTerm_Pattern();

  /**
   * Returns the meta object for class '{@link ElseIfTerm <em>Else If Term</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Else If Term</em>'.
   * @see ElseIfTerm
   * @generated
   */
  EClass getElseIfTerm();

  /**
   * Returns the meta object for the containment reference list '{@link ElseIfTerm#getLogical <em>Logical</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Logical</em>'.
   * @see ElseIfTerm#getLogical()
   * @see #getElseIfTerm()
   * @generated
   */
  EReference getElseIfTerm_Logical();

  /**
   * Returns the meta object for the containment reference list '{@link ElseIfTerm#getPattern <em>Pattern</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Pattern</em>'.
   * @see ElseIfTerm#getPattern()
   * @see #getElseIfTerm()
   * @generated
   */
  EReference getElseIfTerm_Pattern();

  /**
   * Returns the meta object for class '{@link ElseTerm <em>Else Term</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Else Term</em>'.
   * @see ElseTerm
   * @generated
   */
  EClass getElseTerm();

  /**
   * Returns the meta object for the containment reference list '{@link ElseTerm#getPattern <em>Pattern</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Pattern</em>'.
   * @see ElseTerm#getPattern()
   * @see #getElseTerm()
   * @generated
   */
  EReference getElseTerm_Pattern();

  /**
   * Returns the meta object for class '{@link TimeArraySize <em>Time Array Size</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Time Array Size</em>'.
   * @see TimeArraySize
   * @generated
   */
  EClass getTimeArraySize();

  /**
   * Returns the meta object for the reference '{@link TimeArraySize#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Name</em>'.
   * @see TimeArraySize#getName()
   * @see #getTimeArraySize()
   * @generated
   */
  EReference getTimeArraySize_Name();

  /**
   * Returns the meta object for class '{@link Objective <em>Objective</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Objective</em>'.
   * @see Objective
   * @generated
   */
  EClass getObjective();

  /**
   * Returns the meta object for the attribute '{@link Objective#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see Objective#getName()
   * @see #getObjective()
   * @generated
   */
  EAttribute getObjective_Name();

  /**
   * Returns the meta object for the containment reference list '{@link Objective#getWeights <em>Weights</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Weights</em>'.
   * @see Objective#getWeights()
   * @see #getObjective()
   * @generated
   */
  EReference getObjective_Weights();

  /**
   * Returns the meta object for class '{@link WeightItem <em>Weight Item</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Weight Item</em>'.
   * @see WeightItem
   * @generated
   */
  EClass getWeightItem();

  /**
   * Returns the meta object for the reference '{@link WeightItem#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see WeightItem#getRef()
   * @see #getWeightItem()
   * @generated
   */
  EReference getWeightItem_Ref();

  /**
   * Returns the meta object for the containment reference '{@link WeightItem#getTa <em>Ta</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Ta</em>'.
   * @see WeightItem#getTa()
   * @see #getWeightItem()
   * @generated
   */
  EReference getWeightItem_Ta();

  /**
   * Returns the meta object for the containment reference '{@link WeightItem#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see WeightItem#getExpression()
   * @see #getWeightItem()
   * @generated
   */
  EReference getWeightItem_Expression();

  /**
   * Returns the meta object for class '{@link ExternalDef <em>External Def</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>External Def</em>'.
   * @see ExternalDef
   * @generated
   */
  EClass getExternalDef();

  /**
   * Returns the meta object for the containment reference '{@link ExternalDef#getDefinition <em>Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Definition</em>'.
   * @see ExternalDef#getDefinition()
   * @see #getExternalDef()
   * @generated
   */
  EReference getExternalDef_Definition();

  /**
   * Returns the meta object for class '{@link SvarDef <em>Svar Def</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Svar Def</em>'.
   * @see SvarDef
   * @generated
   */
  EClass getSvarDef();

  /**
   * Returns the meta object for the containment reference '{@link SvarDef#getTa <em>Ta</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Ta</em>'.
   * @see SvarDef#getTa()
   * @see #getSvarDef()
   * @generated
   */
  EReference getSvarDef_Ta();

  /**
   * Returns the meta object for the containment reference '{@link SvarDef#getDefinition <em>Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Definition</em>'.
   * @see SvarDef#getDefinition()
   * @see #getSvarDef()
   * @generated
   */
  EReference getSvarDef_Definition();

  /**
   * Returns the meta object for class '{@link DvarDef <em>Dvar Def</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Dvar Def</em>'.
   * @see DvarDef
   * @generated
   */
  EClass getDvarDef();

  /**
   * Returns the meta object for the containment reference '{@link DvarDef#getDefinition <em>Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Definition</em>'.
   * @see DvarDef#getDefinition()
   * @see #getDvarDef()
   * @generated
   */
  EReference getDvarDef_Definition();

  /**
   * Returns the meta object for class '{@link ConstDef <em>Const Def</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Const Def</em>'.
   * @see ConstDef
   * @generated
   */
  EClass getConstDef();

  /**
   * Returns the meta object for the attribute '{@link ConstDef#getDefinition <em>Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Definition</em>'.
   * @see ConstDef#getDefinition()
   * @see #getConstDef()
   * @generated
   */
  EAttribute getConstDef_Definition();

  /**
   * Returns the meta object for class '{@link Alias <em>Alias</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Alias</em>'.
   * @see Alias
   * @generated
   */
  EClass getAlias();

  /**
   * Returns the meta object for the containment reference '{@link Alias#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see Alias#getExpression()
   * @see #getAlias()
   * @generated
   */
  EReference getAlias_Expression();

  /**
   * Returns the meta object for the attribute '{@link Alias#getKind <em>Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Kind</em>'.
   * @see Alias#getKind()
   * @see #getAlias()
   * @generated
   */
  EAttribute getAlias_Kind();

  /**
   * Returns the meta object for the attribute '{@link Alias#getUnits <em>Units</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Units</em>'.
   * @see Alias#getUnits()
   * @see #getAlias()
   * @generated
   */
  EAttribute getAlias_Units();

  /**
   * Returns the meta object for class '{@link External <em>External</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>External</em>'.
   * @see External
   * @generated
   */
  EClass getExternal();

  /**
   * Returns the meta object for the attribute '{@link External#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see External#getName()
   * @see #getExternal()
   * @generated
   */
  EAttribute getExternal_Name();

  /**
   * Returns the meta object for class '{@link DVar <em>DVar</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>DVar</em>'.
   * @see DVar
   * @generated
   */
  EClass getDVar();

  /**
   * Returns the meta object for the attribute '{@link DVar#getKind <em>Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Kind</em>'.
   * @see DVar#getKind()
   * @see #getDVar()
   * @generated
   */
  EAttribute getDVar_Kind();

  /**
   * Returns the meta object for the attribute '{@link DVar#getUnits <em>Units</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Units</em>'.
   * @see DVar#getUnits()
   * @see #getDVar()
   * @generated
   */
  EAttribute getDVar_Units();

  /**
   * Returns the meta object for class '{@link DVarNonStd <em>DVar Non Std</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>DVar Non Std</em>'.
   * @see DVarNonStd
   * @generated
   */
  EClass getDVarNonStd();

  /**
   * Returns the meta object for the containment reference '{@link DVarNonStd#getLowerUpper <em>Lower Upper</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Lower Upper</em>'.
   * @see DVarNonStd#getLowerUpper()
   * @see #getDVarNonStd()
   * @generated
   */
  EReference getDVarNonStd_LowerUpper();

  /**
   * Returns the meta object for class '{@link DVarStd <em>DVar Std</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>DVar Std</em>'.
   * @see DVarStd
   * @generated
   */
  EClass getDVarStd();

  /**
   * Returns the meta object for class '{@link DVarInteger <em>DVar Integer</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>DVar Integer</em>'.
   * @see DVarInteger
   * @generated
   */
  EClass getDVarInteger();

  /**
   * Returns the meta object for class '{@link DVarIntegerStd <em>DVar Integer Std</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>DVar Integer Std</em>'.
   * @see DVarIntegerStd
   * @generated
   */
  EClass getDVarIntegerStd();

  /**
   * Returns the meta object for the attribute '{@link DVarIntegerStd#getKind <em>Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Kind</em>'.
   * @see DVarIntegerStd#getKind()
   * @see #getDVarIntegerStd()
   * @generated
   */
  EAttribute getDVarIntegerStd_Kind();

  /**
   * Returns the meta object for the attribute '{@link DVarIntegerStd#getUnits <em>Units</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Units</em>'.
   * @see DVarIntegerStd#getUnits()
   * @see #getDVarIntegerStd()
   * @generated
   */
  EAttribute getDVarIntegerStd_Units();

  /**
   * Returns the meta object for class '{@link DVarIntegerNonStd <em>DVar Integer Non Std</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>DVar Integer Non Std</em>'.
   * @see DVarIntegerNonStd
   * @generated
   */
  EClass getDVarIntegerNonStd();

  /**
   * Returns the meta object for class '{@link SVar <em>SVar</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>SVar</em>'.
   * @see SVar
   * @generated
   */
  EClass getSVar();

  /**
   * Returns the meta object for class '{@link SVarDSS <em>SVar DSS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>SVar DSS</em>'.
   * @see SVarDSS
   * @generated
   */
  EClass getSVarDSS();

  /**
   * Returns the meta object for the attribute '{@link SVarDSS#getBPart <em>BPart</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>BPart</em>'.
   * @see SVarDSS#getBPart()
   * @see #getSVarDSS()
   * @generated
   */
  EAttribute getSVarDSS_BPart();

  /**
   * Returns the meta object for the attribute '{@link SVarDSS#getKind <em>Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Kind</em>'.
   * @see SVarDSS#getKind()
   * @see #getSVarDSS()
   * @generated
   */
  EAttribute getSVarDSS_Kind();

  /**
   * Returns the meta object for the attribute '{@link SVarDSS#getUnits <em>Units</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Units</em>'.
   * @see SVarDSS#getUnits()
   * @see #getSVarDSS()
   * @generated
   */
  EAttribute getSVarDSS_Units();

  /**
   * Returns the meta object for the attribute '{@link SVarDSS#getConvert <em>Convert</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Convert</em>'.
   * @see SVarDSS#getConvert()
   * @see #getSVarDSS()
   * @generated
   */
  EAttribute getSVarDSS_Convert();

  /**
   * Returns the meta object for class '{@link SVarExpression <em>SVar Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>SVar Expression</em>'.
   * @see SVarExpression
   * @generated
   */
  EClass getSVarExpression();

  /**
   * Returns the meta object for the containment reference '{@link SVarExpression#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see SVarExpression#getExpression()
   * @see #getSVarExpression()
   * @generated
   */
  EReference getSVarExpression_Expression();

  /**
   * Returns the meta object for class '{@link SVarSum <em>SVar Sum</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>SVar Sum</em>'.
   * @see SVarSum
   * @generated
   */
  EClass getSVarSum();

  /**
   * Returns the meta object for the containment reference '{@link SVarSum#getSumContent <em>Sum Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Sum Content</em>'.
   * @see SVarSum#getSumContent()
   * @see #getSVarSum()
   * @generated
   */
  EReference getSVarSum_SumContent();

  /**
   * Returns the meta object for class '{@link SVarTable <em>SVar Table</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>SVar Table</em>'.
   * @see SVarTable
   * @generated
   */
  EClass getSVarTable();

  /**
   * Returns the meta object for the containment reference '{@link SVarTable#getTableContent <em>Table Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Table Content</em>'.
   * @see SVarTable#getTableContent()
   * @see #getSVarTable()
   * @generated
   */
  EReference getSVarTable_TableContent();

  /**
   * Returns the meta object for class '{@link SVarCase <em>SVar Case</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>SVar Case</em>'.
   * @see SVarCase
   * @generated
   */
  EClass getSVarCase();

  /**
   * Returns the meta object for the containment reference list '{@link SVarCase#getCaseContent <em>Case Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Case Content</em>'.
   * @see SVarCase#getCaseContent()
   * @see #getSVarCase()
   * @generated
   */
  EReference getSVarCase_CaseContent();

  /**
   * Returns the meta object for class '{@link CaseContent <em>Case Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Case Content</em>'.
   * @see CaseContent
   * @generated
   */
  EClass getCaseContent();

  /**
   * Returns the meta object for the attribute '{@link CaseContent#getCaseName <em>Case Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Case Name</em>'.
   * @see CaseContent#getCaseName()
   * @see #getCaseContent()
   * @generated
   */
  EAttribute getCaseContent_CaseName();

  /**
   * Returns the meta object for the containment reference '{@link CaseContent#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see CaseContent#getCondition()
   * @see #getCaseContent()
   * @generated
   */
  EReference getCaseContent_Condition();

  /**
   * Returns the meta object for the containment reference '{@link CaseContent#getContent <em>Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Content</em>'.
   * @see CaseContent#getContent()
   * @see #getCaseContent()
   * @generated
   */
  EReference getCaseContent_Content();

  /**
   * Returns the meta object for class '{@link SumContent <em>Sum Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sum Content</em>'.
   * @see SumContent
   * @generated
   */
  EClass getSumContent();

  /**
   * Returns the meta object for the containment reference '{@link SumContent#getHeader <em>Header</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Header</em>'.
   * @see SumContent#getHeader()
   * @see #getSumContent()
   * @generated
   */
  EReference getSumContent_Header();

  /**
   * Returns the meta object for the containment reference '{@link SumContent#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see SumContent#getExpression()
   * @see #getSumContent()
   * @generated
   */
  EReference getSumContent_Expression();

  /**
   * Returns the meta object for class '{@link SumHeader <em>Sum Header</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sum Header</em>'.
   * @see SumHeader
   * @generated
   */
  EClass getSumHeader();

  /**
   * Returns the meta object for the containment reference '{@link SumHeader#getExpression1 <em>Expression1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression1</em>'.
   * @see SumHeader#getExpression1()
   * @see #getSumHeader()
   * @generated
   */
  EReference getSumHeader_Expression1();

  /**
   * Returns the meta object for the containment reference '{@link SumHeader#getExpression2 <em>Expression2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression2</em>'.
   * @see SumHeader#getExpression2()
   * @see #getSumHeader()
   * @generated
   */
  EReference getSumHeader_Expression2();

  /**
   * Returns the meta object for class '{@link ValueContent <em>Value Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Value Content</em>'.
   * @see ValueContent
   * @generated
   */
  EClass getValueContent();

  /**
   * Returns the meta object for the containment reference '{@link ValueContent#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see ValueContent#getExpression()
   * @see #getValueContent()
   * @generated
   */
  EReference getValueContent_Expression();

  /**
   * Returns the meta object for class '{@link TableContent <em>Table Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Table Content</em>'.
   * @see TableContent
   * @generated
   */
  EClass getTableContent();

  /**
   * Returns the meta object for the attribute '{@link TableContent#getTableName <em>Table Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Table Name</em>'.
   * @see TableContent#getTableName()
   * @see #getTableContent()
   * @generated
   */
  EAttribute getTableContent_TableName();

  /**
   * Returns the meta object for the attribute '{@link TableContent#getFrom <em>From</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>From</em>'.
   * @see TableContent#getFrom()
   * @see #getTableContent()
   * @generated
   */
  EAttribute getTableContent_From();

  /**
   * Returns the meta object for the containment reference '{@link TableContent#getGiven <em>Given</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Given</em>'.
   * @see TableContent#getGiven()
   * @see #getTableContent()
   * @generated
   */
  EReference getTableContent_Given();

  /**
   * Returns the meta object for the attribute '{@link TableContent#getUse <em>Use</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Use</em>'.
   * @see TableContent#getUse()
   * @see #getTableContent()
   * @generated
   */
  EAttribute getTableContent_Use();

  /**
   * Returns the meta object for the containment reference '{@link TableContent#getWhere <em>Where</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Where</em>'.
   * @see TableContent#getWhere()
   * @see #getTableContent()
   * @generated
   */
  EReference getTableContent_Where();

  /**
   * Returns the meta object for class '{@link WhereItems <em>Where Items</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Where Items</em>'.
   * @see WhereItems
   * @generated
   */
  EClass getWhereItems();

  /**
   * Returns the meta object for the containment reference list '{@link WhereItems#getAssignment <em>Assignment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Assignment</em>'.
   * @see WhereItems#getAssignment()
   * @see #getWhereItems()
   * @generated
   */
  EReference getWhereItems_Assignment();

  /**
   * Returns the meta object for class '{@link Assignment <em>Assignment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assignment</em>'.
   * @see Assignment
   * @generated
   */
  EClass getAssignment();

  /**
   * Returns the meta object for the containment reference '{@link Assignment#getTerm <em>Term</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Term</em>'.
   * @see Assignment#getTerm()
   * @see #getAssignment()
   * @generated
   */
  EReference getAssignment_Term();

  /**
   * Returns the meta object for the containment reference '{@link Assignment#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see Assignment#getExpression()
   * @see #getAssignment()
   * @generated
   */
  EReference getAssignment_Expression();

  /**
   * Returns the meta object for class '{@link TermSimple <em>Term Simple</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Term Simple</em>'.
   * @see TermSimple
   * @generated
   */
  EClass getTermSimple();

  /**
   * Returns the meta object for class '{@link LowerAndOrUpper <em>Lower And Or Upper</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Lower And Or Upper</em>'.
   * @see LowerAndOrUpper
   * @generated
   */
  EClass getLowerAndOrUpper();

  /**
   * Returns the meta object for the attribute '{@link LowerAndOrUpper#getKind <em>Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Kind</em>'.
   * @see LowerAndOrUpper#getKind()
   * @see #getLowerAndOrUpper()
   * @generated
   */
  EAttribute getLowerAndOrUpper_Kind();

  /**
   * Returns the meta object for the attribute '{@link LowerAndOrUpper#getUnits <em>Units</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Units</em>'.
   * @see LowerAndOrUpper#getUnits()
   * @see #getLowerAndOrUpper()
   * @generated
   */
  EAttribute getLowerAndOrUpper_Units();

  /**
   * Returns the meta object for the containment reference '{@link LowerAndOrUpper#getUpper <em>Upper</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Upper</em>'.
   * @see LowerAndOrUpper#getUpper()
   * @see #getLowerAndOrUpper()
   * @generated
   */
  EReference getLowerAndOrUpper_Upper();

  /**
   * Returns the meta object for the containment reference '{@link LowerAndOrUpper#getLower <em>Lower</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Lower</em>'.
   * @see LowerAndOrUpper#getLower()
   * @see #getLowerAndOrUpper()
   * @generated
   */
  EReference getLowerAndOrUpper_Lower();

  /**
   * Returns the meta object for class '{@link upperLower <em>upper Lower</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>upper Lower</em>'.
   * @see upperLower
   * @generated
   */
  EClass getupperLower();

  /**
   * Returns the meta object for class '{@link lowerUpper <em>lower Upper</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>lower Upper</em>'.
   * @see lowerUpper
   * @generated
   */
  EClass getlowerUpper();

  /**
   * Returns the meta object for class '{@link Upper <em>Upper</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Upper</em>'.
   * @see Upper
   * @generated
   */
  EClass getUpper();

  /**
   * Returns the meta object for the containment reference '{@link Upper#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see Upper#getExpression()
   * @see #getUpper()
   * @generated
   */
  EReference getUpper_Expression();

  /**
   * Returns the meta object for class '{@link Lower <em>Lower</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Lower</em>'.
   * @see Lower
   * @generated
   */
  EClass getLower();

  /**
   * Returns the meta object for the containment reference '{@link Lower#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see Lower#getExpression()
   * @see #getLower()
   * @generated
   */
  EReference getLower_Expression();

  /**
   * Returns the meta object for class '{@link Goal <em>Goal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Goal</em>'.
   * @see Goal
   * @generated
   */
  EClass getGoal();

  /**
   * Returns the meta object for the containment reference '{@link Goal#getTa <em>Ta</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Ta</em>'.
   * @see Goal#getTa()
   * @see #getGoal()
   * @generated
   */
  EReference getGoal_Ta();

  /**
   * Returns the meta object for the attribute '{@link Goal#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see Goal#getName()
   * @see #getGoal()
   * @generated
   */
  EAttribute getGoal_Name();

  /**
   * Returns the meta object for the containment reference '{@link Goal#getDefinition <em>Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Definition</em>'.
   * @see Goal#getDefinition()
   * @see #getGoal()
   * @generated
   */
  EReference getGoal_Definition();

  /**
   * Returns the meta object for class '{@link GoalCase <em>Goal Case</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Goal Case</em>'.
   * @see GoalCase
   * @generated
   */
  EClass getGoalCase();

  /**
   * Returns the meta object for the containment reference '{@link GoalCase#getLhs <em>Lhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Lhs</em>'.
   * @see GoalCase#getLhs()
   * @see #getGoalCase()
   * @generated
   */
  EReference getGoalCase_Lhs();

  /**
   * Returns the meta object for the containment reference '{@link GoalCase#getContent <em>Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Content</em>'.
   * @see GoalCase#getContent()
   * @see #getGoalCase()
   * @generated
   */
  EReference getGoalCase_Content();

  /**
   * Returns the meta object for the containment reference list '{@link GoalCase#getCaseContent <em>Case Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Case Content</em>'.
   * @see GoalCase#getCaseContent()
   * @see #getGoalCase()
   * @generated
   */
  EReference getGoalCase_CaseContent();

  /**
   * Returns the meta object for class '{@link GoalCaseContent <em>Goal Case Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Goal Case Content</em>'.
   * @see GoalCaseContent
   * @generated
   */
  EClass getGoalCaseContent();

  /**
   * Returns the meta object for the attribute '{@link GoalCaseContent#getCaseName <em>Case Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Case Name</em>'.
   * @see GoalCaseContent#getCaseName()
   * @see #getGoalCaseContent()
   * @generated
   */
  EAttribute getGoalCaseContent_CaseName();

  /**
   * Returns the meta object for the containment reference '{@link GoalCaseContent#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see GoalCaseContent#getCondition()
   * @see #getGoalCaseContent()
   * @generated
   */
  EReference getGoalCaseContent_Condition();

  /**
   * Returns the meta object for the containment reference '{@link GoalCaseContent#getRhs <em>Rhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Rhs</em>'.
   * @see GoalCaseContent#getRhs()
   * @see #getGoalCaseContent()
   * @generated
   */
  EReference getGoalCaseContent_Rhs();

  /**
   * Returns the meta object for the containment reference '{@link GoalCaseContent#getSubContent <em>Sub Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Sub Content</em>'.
   * @see GoalCaseContent#getSubContent()
   * @see #getGoalCaseContent()
   * @generated
   */
  EReference getGoalCaseContent_SubContent();

  /**
   * Returns the meta object for class '{@link GoalNoCaseContent <em>Goal No Case Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Goal No Case Content</em>'.
   * @see GoalNoCaseContent
   * @generated
   */
  EClass getGoalNoCaseContent();

  /**
   * Returns the meta object for the containment reference '{@link GoalNoCaseContent#getRhs <em>Rhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Rhs</em>'.
   * @see GoalNoCaseContent#getRhs()
   * @see #getGoalNoCaseContent()
   * @generated
   */
  EReference getGoalNoCaseContent_Rhs();

  /**
   * Returns the meta object for the containment reference '{@link GoalNoCaseContent#getSubContent <em>Sub Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Sub Content</em>'.
   * @see GoalNoCaseContent#getSubContent()
   * @see #getGoalNoCaseContent()
   * @generated
   */
  EReference getGoalNoCaseContent_SubContent();

  /**
   * Returns the meta object for class '{@link SubContent <em>Sub Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sub Content</em>'.
   * @see SubContent
   * @generated
   */
  EClass getSubContent();

  /**
   * Returns the meta object for the containment reference '{@link SubContent#getGt <em>Gt</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Gt</em>'.
   * @see SubContent#getGt()
   * @see #getSubContent()
   * @generated
   */
  EReference getSubContent_Gt();

  /**
   * Returns the meta object for the containment reference '{@link SubContent#getLt <em>Lt</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Lt</em>'.
   * @see SubContent#getLt()
   * @see #getSubContent()
   * @generated
   */
  EReference getSubContent_Lt();

  /**
   * Returns the meta object for class '{@link LhsGtRhs <em>Lhs Gt Rhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Lhs Gt Rhs</em>'.
   * @see LhsGtRhs
   * @generated
   */
  EClass getLhsGtRhs();

  /**
   * Returns the meta object for the containment reference '{@link LhsGtRhs#getPenalty <em>Penalty</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Penalty</em>'.
   * @see LhsGtRhs#getPenalty()
   * @see #getLhsGtRhs()
   * @generated
   */
  EReference getLhsGtRhs_Penalty();

  /**
   * Returns the meta object for class '{@link LhsLtRhs <em>Lhs Lt Rhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Lhs Lt Rhs</em>'.
   * @see LhsLtRhs
   * @generated
   */
  EClass getLhsLtRhs();

  /**
   * Returns the meta object for the containment reference '{@link LhsLtRhs#getPenalty <em>Penalty</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Penalty</em>'.
   * @see LhsLtRhs#getPenalty()
   * @see #getLhsLtRhs()
   * @generated
   */
  EReference getLhsLtRhs_Penalty();

  /**
   * Returns the meta object for class '{@link Penalty <em>Penalty</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Penalty</em>'.
   * @see Penalty
   * @generated
   */
  EClass getPenalty();

  /**
   * Returns the meta object for the containment reference '{@link Penalty#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see Penalty#getExpression()
   * @see #getPenalty()
   * @generated
   */
  EReference getPenalty_Expression();

  /**
   * Returns the meta object for class '{@link GoalSimple <em>Goal Simple</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Goal Simple</em>'.
   * @see GoalSimple
   * @generated
   */
  EClass getGoalSimple();

  /**
   * Returns the meta object for the containment reference '{@link GoalSimple#getConstraint <em>Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Constraint</em>'.
   * @see GoalSimple#getConstraint()
   * @see #getGoalSimple()
   * @generated
   */
  EReference getGoalSimple_Constraint();

  /**
   * Returns the meta object for class '{@link Constraint <em>Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constraint</em>'.
   * @see Constraint
   * @generated
   */
  EClass getConstraint();

  /**
   * Returns the meta object for the containment reference '{@link Constraint#getLhs <em>Lhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Lhs</em>'.
   * @see Constraint#getLhs()
   * @see #getConstraint()
   * @generated
   */
  EReference getConstraint_Lhs();

  /**
   * Returns the meta object for the attribute '{@link Constraint#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see Constraint#getOperator()
   * @see #getConstraint()
   * @generated
   */
  EAttribute getConstraint_Operator();

  /**
   * Returns the meta object for the containment reference '{@link Constraint#getRhs <em>Rhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Rhs</em>'.
   * @see Constraint#getRhs()
   * @see #getConstraint()
   * @generated
   */
  EReference getConstraint_Rhs();

  /**
   * Returns the meta object for class '{@link Group <em>Group</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Group</em>'.
   * @see Group
   * @generated
   */
  EClass getGroup();

  /**
   * Returns the meta object for the attribute '{@link Group#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see Group#getName()
   * @see #getGroup()
   * @generated
   */
  EAttribute getGroup_Name();

  /**
   * Returns the meta object for the containment reference list '{@link Group#getPattern <em>Pattern</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Pattern</em>'.
   * @see Group#getPattern()
   * @see #getGroup()
   * @generated
   */
  EReference getGroup_Pattern();

  /**
   * Returns the meta object for the containment reference list '{@link Group#getIfincitems <em>Ifincitems</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Ifincitems</em>'.
   * @see Group#getIfincitems()
   * @see #getGroup()
   * @generated
   */
  EReference getGroup_Ifincitems();

  /**
   * Returns the meta object for class '{@link Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the attribute '{@link Model#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see Model#getName()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_Name();

  /**
   * Returns the meta object for the containment reference list '{@link Model#getPattern <em>Pattern</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Pattern</em>'.
   * @see Model#getPattern()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Pattern();

  /**
   * Returns the meta object for the containment reference list '{@link Model#getIfincitems <em>Ifincitems</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Ifincitems</em>'.
   * @see Model#getIfincitems()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Ifincitems();

  /**
   * Returns the meta object for class '{@link Initial <em>Initial</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Initial</em>'.
   * @see Initial
   * @generated
   */
  EClass getInitial();

  /**
   * Returns the meta object for the containment reference list '{@link Initial#getPattern <em>Pattern</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Pattern</em>'.
   * @see Initial#getPattern()
   * @see #getInitial()
   * @generated
   */
  EReference getInitial_Pattern();

  /**
   * Returns the meta object for class '{@link Sequence <em>Sequence</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sequence</em>'.
   * @see Sequence
   * @generated
   */
  EClass getSequence();

  /**
   * Returns the meta object for the attribute '{@link Sequence#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see Sequence#getName()
   * @see #getSequence()
   * @generated
   */
  EAttribute getSequence_Name();

  /**
   * Returns the meta object for the reference '{@link Sequence#getModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Model</em>'.
   * @see Sequence#getModel()
   * @see #getSequence()
   * @generated
   */
  EReference getSequence_Model();

  /**
   * Returns the meta object for the containment reference '{@link Sequence#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see Sequence#getCondition()
   * @see #getSequence()
   * @generated
   */
  EReference getSequence_Condition();

  /**
   * Returns the meta object for the attribute '{@link Sequence#getOrder <em>Order</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Order</em>'.
   * @see Sequence#getOrder()
   * @see #getSequence()
   * @generated
   */
  EAttribute getSequence_Order();

  /**
   * Returns the meta object for class '{@link Condition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Condition</em>'.
   * @see Condition
   * @generated
   */
  EClass getCondition();

  /**
   * Returns the meta object for the containment reference '{@link Condition#getLogical <em>Logical</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Logical</em>'.
   * @see Condition#getLogical()
   * @see #getCondition()
   * @generated
   */
  EReference getCondition_Logical();

  /**
   * Returns the meta object for class '{@link LogicalExpression <em>Logical Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Logical Expression</em>'.
   * @see LogicalExpression
   * @generated
   */
  EClass getLogicalExpression();

  /**
   * Returns the meta object for the containment reference '{@link LogicalExpression#getC1 <em>C1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>C1</em>'.
   * @see LogicalExpression#getC1()
   * @see #getLogicalExpression()
   * @generated
   */
  EReference getLogicalExpression_C1();

  /**
   * Returns the meta object for the containment reference list '{@link LogicalExpression#getC2 <em>C2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>C2</em>'.
   * @see LogicalExpression#getC2()
   * @see #getLogicalExpression()
   * @generated
   */
  EReference getLogicalExpression_C2();

  /**
   * Returns the meta object for class '{@link ConditionalUnary <em>Conditional Unary</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Conditional Unary</em>'.
   * @see ConditionalUnary
   * @generated
   */
  EClass getConditionalUnary();

  /**
   * Returns the meta object for class '{@link ConditionalTerm <em>Conditional Term</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Conditional Term</em>'.
   * @see ConditionalTerm
   * @generated
   */
  EClass getConditionalTerm();

  /**
   * Returns the meta object for the containment reference '{@link ConditionalTerm#getE1 <em>E1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>E1</em>'.
   * @see ConditionalTerm#getE1()
   * @see #getConditionalTerm()
   * @generated
   */
  EReference getConditionalTerm_E1();

  /**
   * Returns the meta object for the containment reference '{@link ConditionalTerm#getE2 <em>E2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>E2</em>'.
   * @see ConditionalTerm#getE2()
   * @see #getConditionalTerm()
   * @generated
   */
  EReference getConditionalTerm_E2();

  /**
   * Returns the meta object for class '{@link Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for class '{@link Add <em>Add</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Add</em>'.
   * @see Add
   * @generated
   */
  EClass getAdd();

  /**
   * Returns the meta object for the containment reference '{@link Add#getM1 <em>M1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>M1</em>'.
   * @see Add#getM1()
   * @see #getAdd()
   * @generated
   */
  EReference getAdd_M1();

  /**
   * Returns the meta object for the containment reference list '{@link Add#getM2 <em>M2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>M2</em>'.
   * @see Add#getM2()
   * @see #getAdd()
   * @generated
   */
  EReference getAdd_M2();

  /**
   * Returns the meta object for class '{@link Multiply <em>Multiply</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multiply</em>'.
   * @see Multiply
   * @generated
   */
  EClass getMultiply();

  /**
   * Returns the meta object for the containment reference '{@link Multiply#getU1 <em>U1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>U1</em>'.
   * @see Multiply#getU1()
   * @see #getMultiply()
   * @generated
   */
  EReference getMultiply_U1();

  /**
   * Returns the meta object for the containment reference list '{@link Multiply#getU2 <em>U2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>U2</em>'.
   * @see Multiply#getU2()
   * @see #getMultiply()
   * @generated
   */
  EReference getMultiply_U2();

  /**
   * Returns the meta object for class '{@link Unary <em>Unary</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unary</em>'.
   * @see Unary
   * @generated
   */
  EClass getUnary();

  /**
   * Returns the meta object for class '{@link Term <em>Term</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Term</em>'.
   * @see Term
   * @generated
   */
  EClass getTerm();

  /**
   * Returns the meta object for the reference '{@link Term#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see Term#getRef()
   * @see #getTerm()
   * @generated
   */
  EReference getTerm_Ref();

  /**
   * Returns the meta object for the attribute '{@link Term#getN <em>N</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>N</em>'.
   * @see Term#getN()
   * @see #getTerm()
   * @generated
   */
  EAttribute getTerm_N();

  /**
   * Returns the meta object for the containment reference '{@link Term#getF <em>F</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>F</em>'.
   * @see Term#getF()
   * @see #getTerm()
   * @generated
   */
  EReference getTerm_F();

  /**
   * Returns the meta object for the containment reference '{@link Term#getE <em>E</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>E</em>'.
   * @see Term#getE()
   * @see #getTerm()
   * @generated
   */
  EReference getTerm_E();

  /**
   * Returns the meta object for the attribute '{@link Term#getS <em>S</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>S</em>'.
   * @see Term#getS()
   * @see #getTerm()
   * @generated
   */
  EAttribute getTerm_S();

  /**
   * Returns the meta object for class '{@link Function <em>Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Function</em>'.
   * @see Function
   * @generated
   */
  EClass getFunction();

  /**
   * Returns the meta object for class '{@link ExternalFunction1 <em>External Function1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>External Function1</em>'.
   * @see ExternalFunction1
   * @generated
   */
  EClass getExternalFunction1();

  /**
   * Returns the meta object for the reference '{@link ExternalFunction1#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see ExternalFunction1#getRef()
   * @see #getExternalFunction1()
   * @generated
   */
  EReference getExternalFunction1_Ref();

  /**
   * Returns the meta object for the containment reference '{@link ExternalFunction1#getE1 <em>E1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>E1</em>'.
   * @see ExternalFunction1#getE1()
   * @see #getExternalFunction1()
   * @generated
   */
  EReference getExternalFunction1_E1();

  /**
   * Returns the meta object for the containment reference list '{@link ExternalFunction1#getE2 <em>E2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>E2</em>'.
   * @see ExternalFunction1#getE2()
   * @see #getExternalFunction1()
   * @generated
   */
  EReference getExternalFunction1_E2();

  /**
   * Returns the meta object for the containment reference '{@link ExternalFunction1#getE0 <em>E0</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>E0</em>'.
   * @see ExternalFunction1#getE0()
   * @see #getExternalFunction1()
   * @generated
   */
  EReference getExternalFunction1_E0();

  /**
   * Returns the meta object for class '{@link ExternalFunction2 <em>External Function2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>External Function2</em>'.
   * @see ExternalFunction2
   * @generated
   */
  EClass getExternalFunction2();

  /**
   * Returns the meta object for the reference '{@link ExternalFunction2#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see ExternalFunction2#getRef()
   * @see #getExternalFunction2()
   * @generated
   */
  EReference getExternalFunction2_Ref();

  /**
   * Returns the meta object for class '{@link TrunkTimeArray <em>Trunk Time Array</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Trunk Time Array</em>'.
   * @see TrunkTimeArray
   * @generated
   */
  EClass getTrunkTimeArray();

  /**
   * Returns the meta object for the reference '{@link TrunkTimeArray#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see TrunkTimeArray#getRef()
   * @see #getTrunkTimeArray()
   * @generated
   */
  EReference getTrunkTimeArray_Ref();

  /**
   * Returns the meta object for the containment reference '{@link TrunkTimeArray#getT1 <em>T1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>T1</em>'.
   * @see TrunkTimeArray#getT1()
   * @see #getTrunkTimeArray()
   * @generated
   */
  EReference getTrunkTimeArray_T1();

  /**
   * Returns the meta object for the containment reference '{@link TrunkTimeArray#getT2 <em>T2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>T2</em>'.
   * @see TrunkTimeArray#getT2()
   * @see #getTrunkTimeArray()
   * @generated
   */
  EReference getTrunkTimeArray_T2();

  /**
   * Returns the meta object for class '{@link TrunkTimeArrayIndex <em>Trunk Time Array Index</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Trunk Time Array Index</em>'.
   * @see TrunkTimeArrayIndex
   * @generated
   */
  EClass getTrunkTimeArrayIndex();

  /**
   * Returns the meta object for the reference '{@link TrunkTimeArrayIndex#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see TrunkTimeArrayIndex#getRef()
   * @see #getTrunkTimeArrayIndex()
   * @generated
   */
  EReference getTrunkTimeArrayIndex_Ref();

  /**
   * Returns the meta object for class '{@link MaxFunction <em>Max Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Max Function</em>'.
   * @see MaxFunction
   * @generated
   */
  EClass getMaxFunction();

  /**
   * Returns the meta object for the containment reference '{@link MaxFunction#getE1 <em>E1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>E1</em>'.
   * @see MaxFunction#getE1()
   * @see #getMaxFunction()
   * @generated
   */
  EReference getMaxFunction_E1();

  /**
   * Returns the meta object for the containment reference list '{@link MaxFunction#getE2 <em>E2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>E2</em>'.
   * @see MaxFunction#getE2()
   * @see #getMaxFunction()
   * @generated
   */
  EReference getMaxFunction_E2();

  /**
   * Returns the meta object for class '{@link MinFunction <em>Min Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Min Function</em>'.
   * @see MinFunction
   * @generated
   */
  EClass getMinFunction();

  /**
   * Returns the meta object for the containment reference '{@link MinFunction#getE1 <em>E1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>E1</em>'.
   * @see MinFunction#getE1()
   * @see #getMinFunction()
   * @generated
   */
  EReference getMinFunction_E1();

  /**
   * Returns the meta object for the containment reference list '{@link MinFunction#getE2 <em>E2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>E2</em>'.
   * @see MinFunction#getE2()
   * @see #getMinFunction()
   * @generated
   */
  EReference getMinFunction_E2();

  /**
   * Returns the meta object for class '{@link ModFunction <em>Mod Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Mod Function</em>'.
   * @see ModFunction
   * @generated
   */
  EClass getModFunction();

  /**
   * Returns the meta object for the containment reference '{@link ModFunction#getE1 <em>E1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>E1</em>'.
   * @see ModFunction#getE1()
   * @see #getModFunction()
   * @generated
   */
  EReference getModFunction_E1();

  /**
   * Returns the meta object for the containment reference '{@link ModFunction#getE2 <em>E2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>E2</em>'.
   * @see ModFunction#getE2()
   * @see #getModFunction()
   * @generated
   */
  EReference getModFunction_E2();

  /**
   * Returns the meta object for class '{@link IntFunction <em>Int Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Int Function</em>'.
   * @see IntFunction
   * @generated
   */
  EClass getIntFunction();

  /**
   * Returns the meta object for the containment reference '{@link IntFunction#getE <em>E</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>E</em>'.
   * @see IntFunction#getE()
   * @see #getIntFunction()
   * @generated
   */
  EReference getIntFunction_E();

  /**
   * Returns the meta object for class '{@link AbsFunction <em>Abs Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abs Function</em>'.
   * @see AbsFunction
   * @generated
   */
  EClass getAbsFunction();

  /**
   * Returns the meta object for the containment reference '{@link AbsFunction#getE <em>E</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>E</em>'.
   * @see AbsFunction#getE()
   * @see #getAbsFunction()
   * @generated
   */
  EReference getAbsFunction_E();

  /**
   * Returns the meta object for class '{@link RoundFunction <em>Round Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Round Function</em>'.
   * @see RoundFunction
   * @generated
   */
  EClass getRoundFunction();

  /**
   * Returns the meta object for the containment reference '{@link RoundFunction#getE <em>E</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>E</em>'.
   * @see RoundFunction#getE()
   * @see #getRoundFunction()
   * @generated
   */
  EReference getRoundFunction_E();

  /**
   * Returns the meta object for class '{@link PowFunction <em>Pow Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Pow Function</em>'.
   * @see PowFunction
   * @generated
   */
  EClass getPowFunction();

  /**
   * Returns the meta object for the containment reference '{@link PowFunction#getE1 <em>E1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>E1</em>'.
   * @see PowFunction#getE1()
   * @see #getPowFunction()
   * @generated
   */
  EReference getPowFunction_E1();

  /**
   * Returns the meta object for the containment reference '{@link PowFunction#getE2 <em>E2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>E2</em>'.
   * @see PowFunction#getE2()
   * @see #getPowFunction()
   * @generated
   */
  EReference getPowFunction_E2();

  /**
   * Returns the meta object for class '{@link LogFunction <em>Log Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Log Function</em>'.
   * @see LogFunction
   * @generated
   */
  EClass getLogFunction();

  /**
   * Returns the meta object for the containment reference '{@link LogFunction#getE <em>E</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>E</em>'.
   * @see LogFunction#getE()
   * @see #getLogFunction()
   * @generated
   */
  EReference getLogFunction_E();

  /**
   * Returns the meta object for class '{@link SinFunction <em>Sin Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sin Function</em>'.
   * @see SinFunction
   * @generated
   */
  EClass getSinFunction();

  /**
   * Returns the meta object for the containment reference '{@link SinFunction#getE <em>E</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>E</em>'.
   * @see SinFunction#getE()
   * @see #getSinFunction()
   * @generated
   */
  EReference getSinFunction_E();

  /**
   * Returns the meta object for class '{@link CosFunction <em>Cos Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Cos Function</em>'.
   * @see CosFunction
   * @generated
   */
  EClass getCosFunction();

  /**
   * Returns the meta object for the containment reference '{@link CosFunction#getE <em>E</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>E</em>'.
   * @see CosFunction#getE()
   * @see #getCosFunction()
   * @generated
   */
  EReference getCosFunction_E();

  /**
   * Returns the meta object for class '{@link TanFunction <em>Tan Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tan Function</em>'.
   * @see TanFunction
   * @generated
   */
  EClass getTanFunction();

  /**
   * Returns the meta object for the containment reference '{@link TanFunction#getE <em>E</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>E</em>'.
   * @see TanFunction#getE()
   * @see #getTanFunction()
   * @generated
   */
  EReference getTanFunction_E();

  /**
   * Returns the meta object for class '{@link CotFunction <em>Cot Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Cot Function</em>'.
   * @see CotFunction
   * @generated
   */
  EClass getCotFunction();

  /**
   * Returns the meta object for the containment reference '{@link CotFunction#getE <em>E</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>E</em>'.
   * @see CotFunction#getE()
   * @see #getCotFunction()
   * @generated
   */
  EReference getCotFunction_E();

  /**
   * Returns the meta object for class '{@link AsinFunction <em>Asin Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Asin Function</em>'.
   * @see AsinFunction
   * @generated
   */
  EClass getAsinFunction();

  /**
   * Returns the meta object for the containment reference '{@link AsinFunction#getE <em>E</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>E</em>'.
   * @see AsinFunction#getE()
   * @see #getAsinFunction()
   * @generated
   */
  EReference getAsinFunction_E();

  /**
   * Returns the meta object for class '{@link AcosFunction <em>Acos Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Acos Function</em>'.
   * @see AcosFunction
   * @generated
   */
  EClass getAcosFunction();

  /**
   * Returns the meta object for the containment reference '{@link AcosFunction#getE <em>E</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>E</em>'.
   * @see AcosFunction#getE()
   * @see #getAcosFunction()
   * @generated
   */
  EReference getAcosFunction_E();

  /**
   * Returns the meta object for class '{@link AtanFunction <em>Atan Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Atan Function</em>'.
   * @see AtanFunction
   * @generated
   */
  EClass getAtanFunction();

  /**
   * Returns the meta object for the containment reference '{@link AtanFunction#getE <em>E</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>E</em>'.
   * @see AtanFunction#getE()
   * @see #getAtanFunction()
   * @generated
   */
  EReference getAtanFunction_E();

  /**
   * Returns the meta object for class '{@link AcotFunction <em>Acot Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Acot Function</em>'.
   * @see AcotFunction
   * @generated
   */
  EClass getAcotFunction();

  /**
   * Returns the meta object for the containment reference '{@link AcotFunction#getE <em>E</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>E</em>'.
   * @see AcotFunction#getE()
   * @see #getAcotFunction()
   * @generated
   */
  EReference getAcotFunction_E();

  /**
   * Returns the meta object for class '{@link VarModel <em>Var Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Var Model</em>'.
   * @see VarModel
   * @generated
   */
  EClass getVarModel();

  /**
   * Returns the meta object for the reference '{@link VarModel#getRef1 <em>Ref1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref1</em>'.
   * @see VarModel#getRef1()
   * @see #getVarModel()
   * @generated
   */
  EReference getVarModel_Ref1();

  /**
   * Returns the meta object for the reference '{@link VarModel#getRef2 <em>Ref2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref2</em>'.
   * @see VarModel#getRef2()
   * @see #getVarModel()
   * @generated
   */
  EReference getVarModel_Ref2();

  /**
   * Returns the meta object for class '{@link VarModelStep <em>Var Model Step</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Var Model Step</em>'.
   * @see VarModelStep
   * @generated
   */
  EClass getVarModelStep();

  /**
   * Returns the meta object for the reference '{@link VarModelStep#getRef1 <em>Ref1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref1</em>'.
   * @see VarModelStep#getRef1()
   * @see #getVarModelStep()
   * @generated
   */
  EReference getVarModelStep_Ref1();

  /**
   * Returns the meta object for the reference '{@link VarModelStep#getRef2 <em>Ref2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref2</em>'.
   * @see VarModelStep#getRef2()
   * @see #getVarModelStep()
   * @generated
   */
  EReference getVarModelStep_Ref2();

  /**
   * Returns the meta object for the containment reference '{@link VarModelStep#getE <em>E</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>E</em>'.
   * @see VarModelStep#getE()
   * @see #getVarModelStep()
   * @generated
   */
  EReference getVarModelStep_E();

  /**
   * Returns the meta object for class '{@link VarModelIndex <em>Var Model Index</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Var Model Index</em>'.
   * @see VarModelIndex
   * @generated
   */
  EClass getVarModelIndex();

  /**
   * Returns the meta object for the reference '{@link VarModelIndex#getRef1 <em>Ref1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref1</em>'.
   * @see VarModelIndex#getRef1()
   * @see #getVarModelIndex()
   * @generated
   */
  EReference getVarModelIndex_Ref1();

  /**
   * Returns the meta object for class '{@link VarModelIndexStep <em>Var Model Index Step</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Var Model Index Step</em>'.
   * @see VarModelIndexStep
   * @generated
   */
  EClass getVarModelIndexStep();

  /**
   * Returns the meta object for the reference '{@link VarModelIndexStep#getRef1 <em>Ref1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref1</em>'.
   * @see VarModelIndexStep#getRef1()
   * @see #getVarModelIndexStep()
   * @generated
   */
  EReference getVarModelIndexStep_Ref1();

  /**
   * Returns the meta object for the containment reference '{@link VarModelIndexStep#getE <em>E</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>E</em>'.
   * @see VarModelIndexStep#getE()
   * @see #getVarModelIndexStep()
   * @generated
   */
  EReference getVarModelIndexStep_E();

  /**
   * Returns the meta object for class '{@link Ident <em>Ident</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Ident</em>'.
   * @see Ident
   * @generated
   */
  EClass getIdent();

  /**
   * Returns the meta object for the attribute '{@link Ident#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see Ident#getName()
   * @see #getIdent()
   * @generated
   */
  EAttribute getIdent_Name();

  /**
   * Returns the meta object for class '{@link IncludeFile <em>Include File</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Include File</em>'.
   * @see IncludeFile
   * @generated
   */
  EClass getIncludeFile();

  /**
   * Returns the meta object for the attribute '{@link IncludeFile#getFile <em>File</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>File</em>'.
   * @see IncludeFile#getFile()
   * @see #getIncludeFile()
   * @generated
   */
  EAttribute getIncludeFile_File();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  WreslEditorFactory getWreslEditorFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link WreslEvaluatorImpl <em>Wresl Evaluator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see WreslEvaluatorImpl
     * @see WreslEditorPackageImpl#getWreslEvaluator()
     * @generated
     */
    EClass WRESL_EVALUATOR = eINSTANCE.getWreslEvaluator();

    /**
     * The meta object literal for the '<em><b>Pattern</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WRESL_EVALUATOR__PATTERN = eINSTANCE.getWreslEvaluator_Pattern();

    /**
     * The meta object literal for the '<em><b>Ifincitem</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WRESL_EVALUATOR__IFINCITEM = eINSTANCE.getWreslEvaluator_Ifincitem();

    /**
     * The meta object literal for the '<em><b>Initial</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WRESL_EVALUATOR__INITIAL = eINSTANCE.getWreslEvaluator_Initial();

    /**
     * The meta object literal for the '<em><b>Sequence</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WRESL_EVALUATOR__SEQUENCE = eINSTANCE.getWreslEvaluator_Sequence();

    /**
     * The meta object literal for the '<em><b>Model</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WRESL_EVALUATOR__MODEL = eINSTANCE.getWreslEvaluator_Model();

    /**
     * The meta object literal for the '{@link PatternImpl <em>Pattern</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see PatternImpl
     * @see WreslEditorPackageImpl#getPattern()
     * @generated
     */
    EClass PATTERN = eINSTANCE.getPattern();

    /**
     * The meta object literal for the '<em><b>Local</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PATTERN__LOCAL = eINSTANCE.getPattern_Local();

    /**
     * The meta object literal for the '{@link DeclarationImpl <em>Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see DeclarationImpl
     * @see WreslEditorPackageImpl#getDeclaration()
     * @generated
     */
    EClass DECLARATION = eINSTANCE.getDeclaration();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DECLARATION__NAME = eINSTANCE.getDeclaration_Name();

    /**
     * The meta object literal for the '{@link VariableImpl <em>Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see VariableImpl
     * @see WreslEditorPackageImpl#getVariable()
     * @generated
     */
    EClass VARIABLE = eINSTANCE.getVariable();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE__REF = eINSTANCE.getVariable_Ref();

    /**
     * The meta object literal for the '{@link StateVariableImpl <em>State Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see StateVariableImpl
     * @see WreslEditorPackageImpl#getStateVariable()
     * @generated
     */
    EClass STATE_VARIABLE = eINSTANCE.getStateVariable();

    /**
     * The meta object literal for the '{@link DecisionVariableImpl <em>Decision Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see DecisionVariableImpl
     * @see WreslEditorPackageImpl#getDecisionVariable()
     * @generated
     */
    EClass DECISION_VARIABLE = eINSTANCE.getDecisionVariable();

    /**
     * The meta object literal for the '<em><b>Ta</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DECISION_VARIABLE__TA = eINSTANCE.getDecisionVariable_Ta();

    /**
     * The meta object literal for the '{@link IfIncItemsImpl <em>If Inc Items</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see IfIncItemsImpl
     * @see WreslEditorPackageImpl#getIfIncItems()
     * @generated
     */
    EClass IF_INC_ITEMS = eINSTANCE.getIfIncItems();

    /**
     * The meta object literal for the '{@link IfTermImpl <em>If Term</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see IfTermImpl
     * @see WreslEditorPackageImpl#getIfTerm()
     * @generated
     */
    EClass IF_TERM = eINSTANCE.getIfTerm();

    /**
     * The meta object literal for the '<em><b>Elseifterm</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_TERM__ELSEIFTERM = eINSTANCE.getIfTerm_Elseifterm();

    /**
     * The meta object literal for the '<em><b>Elseterm</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_TERM__ELSETERM = eINSTANCE.getIfTerm_Elseterm();

    /**
     * The meta object literal for the '<em><b>Logical</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_TERM__LOGICAL = eINSTANCE.getIfTerm_Logical();

    /**
     * The meta object literal for the '<em><b>Pattern</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_TERM__PATTERN = eINSTANCE.getIfTerm_Pattern();

    /**
     * The meta object literal for the '{@link ElseIfTermImpl <em>Else If Term</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ElseIfTermImpl
     * @see WreslEditorPackageImpl#getElseIfTerm()
     * @generated
     */
    EClass ELSE_IF_TERM = eINSTANCE.getElseIfTerm();

    /**
     * The meta object literal for the '<em><b>Logical</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ELSE_IF_TERM__LOGICAL = eINSTANCE.getElseIfTerm_Logical();

    /**
     * The meta object literal for the '<em><b>Pattern</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ELSE_IF_TERM__PATTERN = eINSTANCE.getElseIfTerm_Pattern();

    /**
     * The meta object literal for the '{@link ElseTermImpl <em>Else Term</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ElseTermImpl
     * @see WreslEditorPackageImpl#getElseTerm()
     * @generated
     */
    EClass ELSE_TERM = eINSTANCE.getElseTerm();

    /**
     * The meta object literal for the '<em><b>Pattern</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ELSE_TERM__PATTERN = eINSTANCE.getElseTerm_Pattern();

    /**
     * The meta object literal for the '{@link TimeArraySizeImpl <em>Time Array Size</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see TimeArraySizeImpl
     * @see WreslEditorPackageImpl#getTimeArraySize()
     * @generated
     */
    EClass TIME_ARRAY_SIZE = eINSTANCE.getTimeArraySize();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TIME_ARRAY_SIZE__NAME = eINSTANCE.getTimeArraySize_Name();

    /**
     * The meta object literal for the '{@link ObjectiveImpl <em>Objective</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ObjectiveImpl
     * @see WreslEditorPackageImpl#getObjective()
     * @generated
     */
    EClass OBJECTIVE = eINSTANCE.getObjective();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OBJECTIVE__NAME = eINSTANCE.getObjective_Name();

    /**
     * The meta object literal for the '<em><b>Weights</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OBJECTIVE__WEIGHTS = eINSTANCE.getObjective_Weights();

    /**
     * The meta object literal for the '{@link WeightItemImpl <em>Weight Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see WeightItemImpl
     * @see WreslEditorPackageImpl#getWeightItem()
     * @generated
     */
    EClass WEIGHT_ITEM = eINSTANCE.getWeightItem();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WEIGHT_ITEM__REF = eINSTANCE.getWeightItem_Ref();

    /**
     * The meta object literal for the '<em><b>Ta</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WEIGHT_ITEM__TA = eINSTANCE.getWeightItem_Ta();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WEIGHT_ITEM__EXPRESSION = eINSTANCE.getWeightItem_Expression();

    /**
     * The meta object literal for the '{@link ExternalDefImpl <em>External Def</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ExternalDefImpl
     * @see WreslEditorPackageImpl#getExternalDef()
     * @generated
     */
    EClass EXTERNAL_DEF = eINSTANCE.getExternalDef();

    /**
     * The meta object literal for the '<em><b>Definition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXTERNAL_DEF__DEFINITION = eINSTANCE.getExternalDef_Definition();

    /**
     * The meta object literal for the '{@link SvarDefImpl <em>Svar Def</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see SvarDefImpl
     * @see WreslEditorPackageImpl#getSvarDef()
     * @generated
     */
    EClass SVAR_DEF = eINSTANCE.getSvarDef();

    /**
     * The meta object literal for the '<em><b>Ta</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SVAR_DEF__TA = eINSTANCE.getSvarDef_Ta();

    /**
     * The meta object literal for the '<em><b>Definition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SVAR_DEF__DEFINITION = eINSTANCE.getSvarDef_Definition();

    /**
     * The meta object literal for the '{@link DvarDefImpl <em>Dvar Def</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see DvarDefImpl
     * @see WreslEditorPackageImpl#getDvarDef()
     * @generated
     */
    EClass DVAR_DEF = eINSTANCE.getDvarDef();

    /**
     * The meta object literal for the '<em><b>Definition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DVAR_DEF__DEFINITION = eINSTANCE.getDvarDef_Definition();

    /**
     * The meta object literal for the '{@link ConstDefImpl <em>Const Def</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ConstDefImpl
     * @see WreslEditorPackageImpl#getConstDef()
     * @generated
     */
    EClass CONST_DEF = eINSTANCE.getConstDef();

    /**
     * The meta object literal for the '<em><b>Definition</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONST_DEF__DEFINITION = eINSTANCE.getConstDef_Definition();

    /**
     * The meta object literal for the '{@link AliasImpl <em>Alias</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see AliasImpl
     * @see WreslEditorPackageImpl#getAlias()
     * @generated
     */
    EClass ALIAS = eINSTANCE.getAlias();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ALIAS__EXPRESSION = eINSTANCE.getAlias_Expression();

    /**
     * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ALIAS__KIND = eINSTANCE.getAlias_Kind();

    /**
     * The meta object literal for the '<em><b>Units</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ALIAS__UNITS = eINSTANCE.getAlias_Units();

    /**
     * The meta object literal for the '{@link ExternalImpl <em>External</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ExternalImpl
     * @see WreslEditorPackageImpl#getExternal()
     * @generated
     */
    EClass EXTERNAL = eINSTANCE.getExternal();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXTERNAL__NAME = eINSTANCE.getExternal_Name();

    /**
     * The meta object literal for the '{@link DVarImpl <em>DVar</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see DVarImpl
     * @see WreslEditorPackageImpl#getDVar()
     * @generated
     */
    EClass DVAR = eINSTANCE.getDVar();

    /**
     * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DVAR__KIND = eINSTANCE.getDVar_Kind();

    /**
     * The meta object literal for the '<em><b>Units</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DVAR__UNITS = eINSTANCE.getDVar_Units();

    /**
     * The meta object literal for the '{@link DVarNonStdImpl <em>DVar Non Std</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see DVarNonStdImpl
     * @see WreslEditorPackageImpl#getDVarNonStd()
     * @generated
     */
    EClass DVAR_NON_STD = eINSTANCE.getDVarNonStd();

    /**
     * The meta object literal for the '<em><b>Lower Upper</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DVAR_NON_STD__LOWER_UPPER = eINSTANCE.getDVarNonStd_LowerUpper();

    /**
     * The meta object literal for the '{@link DVarStdImpl <em>DVar Std</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see DVarStdImpl
     * @see WreslEditorPackageImpl#getDVarStd()
     * @generated
     */
    EClass DVAR_STD = eINSTANCE.getDVarStd();

    /**
     * The meta object literal for the '{@link DVarIntegerImpl <em>DVar Integer</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see DVarIntegerImpl
     * @see WreslEditorPackageImpl#getDVarInteger()
     * @generated
     */
    EClass DVAR_INTEGER = eINSTANCE.getDVarInteger();

    /**
     * The meta object literal for the '{@link DVarIntegerStdImpl <em>DVar Integer Std</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see DVarIntegerStdImpl
     * @see WreslEditorPackageImpl#getDVarIntegerStd()
     * @generated
     */
    EClass DVAR_INTEGER_STD = eINSTANCE.getDVarIntegerStd();

    /**
     * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DVAR_INTEGER_STD__KIND = eINSTANCE.getDVarIntegerStd_Kind();

    /**
     * The meta object literal for the '<em><b>Units</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DVAR_INTEGER_STD__UNITS = eINSTANCE.getDVarIntegerStd_Units();

    /**
     * The meta object literal for the '{@link DVarIntegerNonStdImpl <em>DVar Integer Non Std</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see DVarIntegerNonStdImpl
     * @see WreslEditorPackageImpl#getDVarIntegerNonStd()
     * @generated
     */
    EClass DVAR_INTEGER_NON_STD = eINSTANCE.getDVarIntegerNonStd();

    /**
     * The meta object literal for the '{@link SVarImpl <em>SVar</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see SVarImpl
     * @see WreslEditorPackageImpl#getSVar()
     * @generated
     */
    EClass SVAR = eINSTANCE.getSVar();

    /**
     * The meta object literal for the '{@link SVarDSSImpl <em>SVar DSS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see SVarDSSImpl
     * @see WreslEditorPackageImpl#getSVarDSS()
     * @generated
     */
    EClass SVAR_DSS = eINSTANCE.getSVarDSS();

    /**
     * The meta object literal for the '<em><b>BPart</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SVAR_DSS__BPART = eINSTANCE.getSVarDSS_BPart();

    /**
     * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SVAR_DSS__KIND = eINSTANCE.getSVarDSS_Kind();

    /**
     * The meta object literal for the '<em><b>Units</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SVAR_DSS__UNITS = eINSTANCE.getSVarDSS_Units();

    /**
     * The meta object literal for the '<em><b>Convert</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SVAR_DSS__CONVERT = eINSTANCE.getSVarDSS_Convert();

    /**
     * The meta object literal for the '{@link SVarExpressionImpl <em>SVar Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see SVarExpressionImpl
     * @see WreslEditorPackageImpl#getSVarExpression()
     * @generated
     */
    EClass SVAR_EXPRESSION = eINSTANCE.getSVarExpression();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SVAR_EXPRESSION__EXPRESSION = eINSTANCE.getSVarExpression_Expression();

    /**
     * The meta object literal for the '{@link SVarSumImpl <em>SVar Sum</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see SVarSumImpl
     * @see WreslEditorPackageImpl#getSVarSum()
     * @generated
     */
    EClass SVAR_SUM = eINSTANCE.getSVarSum();

    /**
     * The meta object literal for the '<em><b>Sum Content</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SVAR_SUM__SUM_CONTENT = eINSTANCE.getSVarSum_SumContent();

    /**
     * The meta object literal for the '{@link SVarTableImpl <em>SVar Table</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see SVarTableImpl
     * @see WreslEditorPackageImpl#getSVarTable()
     * @generated
     */
    EClass SVAR_TABLE = eINSTANCE.getSVarTable();

    /**
     * The meta object literal for the '<em><b>Table Content</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SVAR_TABLE__TABLE_CONTENT = eINSTANCE.getSVarTable_TableContent();

    /**
     * The meta object literal for the '{@link SVarCaseImpl <em>SVar Case</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see SVarCaseImpl
     * @see WreslEditorPackageImpl#getSVarCase()
     * @generated
     */
    EClass SVAR_CASE = eINSTANCE.getSVarCase();

    /**
     * The meta object literal for the '<em><b>Case Content</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SVAR_CASE__CASE_CONTENT = eINSTANCE.getSVarCase_CaseContent();

    /**
     * The meta object literal for the '{@link CaseContentImpl <em>Case Content</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see CaseContentImpl
     * @see WreslEditorPackageImpl#getCaseContent()
     * @generated
     */
    EClass CASE_CONTENT = eINSTANCE.getCaseContent();

    /**
     * The meta object literal for the '<em><b>Case Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CASE_CONTENT__CASE_NAME = eINSTANCE.getCaseContent_CaseName();

    /**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CASE_CONTENT__CONDITION = eINSTANCE.getCaseContent_Condition();

    /**
     * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CASE_CONTENT__CONTENT = eINSTANCE.getCaseContent_Content();

    /**
     * The meta object literal for the '{@link SumContentImpl <em>Sum Content</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see SumContentImpl
     * @see WreslEditorPackageImpl#getSumContent()
     * @generated
     */
    EClass SUM_CONTENT = eINSTANCE.getSumContent();

    /**
     * The meta object literal for the '<em><b>Header</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUM_CONTENT__HEADER = eINSTANCE.getSumContent_Header();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUM_CONTENT__EXPRESSION = eINSTANCE.getSumContent_Expression();

    /**
     * The meta object literal for the '{@link SumHeaderImpl <em>Sum Header</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see SumHeaderImpl
     * @see WreslEditorPackageImpl#getSumHeader()
     * @generated
     */
    EClass SUM_HEADER = eINSTANCE.getSumHeader();

    /**
     * The meta object literal for the '<em><b>Expression1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUM_HEADER__EXPRESSION1 = eINSTANCE.getSumHeader_Expression1();

    /**
     * The meta object literal for the '<em><b>Expression2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUM_HEADER__EXPRESSION2 = eINSTANCE.getSumHeader_Expression2();

    /**
     * The meta object literal for the '{@link ValueContentImpl <em>Value Content</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ValueContentImpl
     * @see WreslEditorPackageImpl#getValueContent()
     * @generated
     */
    EClass VALUE_CONTENT = eINSTANCE.getValueContent();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VALUE_CONTENT__EXPRESSION = eINSTANCE.getValueContent_Expression();

    /**
     * The meta object literal for the '{@link TableContentImpl <em>Table Content</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see TableContentImpl
     * @see WreslEditorPackageImpl#getTableContent()
     * @generated
     */
    EClass TABLE_CONTENT = eINSTANCE.getTableContent();

    /**
     * The meta object literal for the '<em><b>Table Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TABLE_CONTENT__TABLE_NAME = eINSTANCE.getTableContent_TableName();

    /**
     * The meta object literal for the '<em><b>From</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TABLE_CONTENT__FROM = eINSTANCE.getTableContent_From();

    /**
     * The meta object literal for the '<em><b>Given</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TABLE_CONTENT__GIVEN = eINSTANCE.getTableContent_Given();

    /**
     * The meta object literal for the '<em><b>Use</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TABLE_CONTENT__USE = eINSTANCE.getTableContent_Use();

    /**
     * The meta object literal for the '<em><b>Where</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TABLE_CONTENT__WHERE = eINSTANCE.getTableContent_Where();

    /**
     * The meta object literal for the '{@link WhereItemsImpl <em>Where Items</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see WhereItemsImpl
     * @see WreslEditorPackageImpl#getWhereItems()
     * @generated
     */
    EClass WHERE_ITEMS = eINSTANCE.getWhereItems();

    /**
     * The meta object literal for the '<em><b>Assignment</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WHERE_ITEMS__ASSIGNMENT = eINSTANCE.getWhereItems_Assignment();

    /**
     * The meta object literal for the '{@link AssignmentImpl <em>Assignment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see AssignmentImpl
     * @see WreslEditorPackageImpl#getAssignment()
     * @generated
     */
    EClass ASSIGNMENT = eINSTANCE.getAssignment();

    /**
     * The meta object literal for the '<em><b>Term</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSIGNMENT__TERM = eINSTANCE.getAssignment_Term();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSIGNMENT__EXPRESSION = eINSTANCE.getAssignment_Expression();

    /**
     * The meta object literal for the '{@link TermSimpleImpl <em>Term Simple</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see TermSimpleImpl
     * @see WreslEditorPackageImpl#getTermSimple()
     * @generated
     */
    EClass TERM_SIMPLE = eINSTANCE.getTermSimple();

    /**
     * The meta object literal for the '{@link LowerAndOrUpperImpl <em>Lower And Or Upper</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see LowerAndOrUpperImpl
     * @see WreslEditorPackageImpl#getLowerAndOrUpper()
     * @generated
     */
    EClass LOWER_AND_OR_UPPER = eINSTANCE.getLowerAndOrUpper();

    /**
     * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOWER_AND_OR_UPPER__KIND = eINSTANCE.getLowerAndOrUpper_Kind();

    /**
     * The meta object literal for the '<em><b>Units</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOWER_AND_OR_UPPER__UNITS = eINSTANCE.getLowerAndOrUpper_Units();

    /**
     * The meta object literal for the '<em><b>Upper</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOWER_AND_OR_UPPER__UPPER = eINSTANCE.getLowerAndOrUpper_Upper();

    /**
     * The meta object literal for the '<em><b>Lower</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOWER_AND_OR_UPPER__LOWER = eINSTANCE.getLowerAndOrUpper_Lower();

    /**
     * The meta object literal for the '{@link upperLowerImpl <em>upper Lower</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see upperLowerImpl
     * @see WreslEditorPackageImpl#getupperLower()
     * @generated
     */
    EClass UPPER_LOWER = eINSTANCE.getupperLower();

    /**
     * The meta object literal for the '{@link lowerUpperImpl <em>lower Upper</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see lowerUpperImpl
     * @see WreslEditorPackageImpl#getlowerUpper()
     * @generated
     */
    EClass LOWER_UPPER = eINSTANCE.getlowerUpper();

    /**
     * The meta object literal for the '{@link UpperImpl <em>Upper</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see UpperImpl
     * @see WreslEditorPackageImpl#getUpper()
     * @generated
     */
    EClass UPPER = eINSTANCE.getUpper();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UPPER__EXPRESSION = eINSTANCE.getUpper_Expression();

    /**
     * The meta object literal for the '{@link LowerImpl <em>Lower</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see LowerImpl
     * @see WreslEditorPackageImpl#getLower()
     * @generated
     */
    EClass LOWER = eINSTANCE.getLower();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOWER__EXPRESSION = eINSTANCE.getLower_Expression();

    /**
     * The meta object literal for the '{@link GoalImpl <em>Goal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see GoalImpl
     * @see WreslEditorPackageImpl#getGoal()
     * @generated
     */
    EClass GOAL = eINSTANCE.getGoal();

    /**
     * The meta object literal for the '<em><b>Ta</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GOAL__TA = eINSTANCE.getGoal_Ta();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GOAL__NAME = eINSTANCE.getGoal_Name();

    /**
     * The meta object literal for the '<em><b>Definition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GOAL__DEFINITION = eINSTANCE.getGoal_Definition();

    /**
     * The meta object literal for the '{@link GoalCaseImpl <em>Goal Case</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see GoalCaseImpl
     * @see WreslEditorPackageImpl#getGoalCase()
     * @generated
     */
    EClass GOAL_CASE = eINSTANCE.getGoalCase();

    /**
     * The meta object literal for the '<em><b>Lhs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GOAL_CASE__LHS = eINSTANCE.getGoalCase_Lhs();

    /**
     * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GOAL_CASE__CONTENT = eINSTANCE.getGoalCase_Content();

    /**
     * The meta object literal for the '<em><b>Case Content</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GOAL_CASE__CASE_CONTENT = eINSTANCE.getGoalCase_CaseContent();

    /**
     * The meta object literal for the '{@link GoalCaseContentImpl <em>Goal Case Content</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see GoalCaseContentImpl
     * @see WreslEditorPackageImpl#getGoalCaseContent()
     * @generated
     */
    EClass GOAL_CASE_CONTENT = eINSTANCE.getGoalCaseContent();

    /**
     * The meta object literal for the '<em><b>Case Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GOAL_CASE_CONTENT__CASE_NAME = eINSTANCE.getGoalCaseContent_CaseName();

    /**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GOAL_CASE_CONTENT__CONDITION = eINSTANCE.getGoalCaseContent_Condition();

    /**
     * The meta object literal for the '<em><b>Rhs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GOAL_CASE_CONTENT__RHS = eINSTANCE.getGoalCaseContent_Rhs();

    /**
     * The meta object literal for the '<em><b>Sub Content</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GOAL_CASE_CONTENT__SUB_CONTENT = eINSTANCE.getGoalCaseContent_SubContent();

    /**
     * The meta object literal for the '{@link GoalNoCaseContentImpl <em>Goal No Case Content</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see GoalNoCaseContentImpl
     * @see WreslEditorPackageImpl#getGoalNoCaseContent()
     * @generated
     */
    EClass GOAL_NO_CASE_CONTENT = eINSTANCE.getGoalNoCaseContent();

    /**
     * The meta object literal for the '<em><b>Rhs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GOAL_NO_CASE_CONTENT__RHS = eINSTANCE.getGoalNoCaseContent_Rhs();

    /**
     * The meta object literal for the '<em><b>Sub Content</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GOAL_NO_CASE_CONTENT__SUB_CONTENT = eINSTANCE.getGoalNoCaseContent_SubContent();

    /**
     * The meta object literal for the '{@link SubContentImpl <em>Sub Content</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see SubContentImpl
     * @see WreslEditorPackageImpl#getSubContent()
     * @generated
     */
    EClass SUB_CONTENT = eINSTANCE.getSubContent();

    /**
     * The meta object literal for the '<em><b>Gt</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUB_CONTENT__GT = eINSTANCE.getSubContent_Gt();

    /**
     * The meta object literal for the '<em><b>Lt</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUB_CONTENT__LT = eINSTANCE.getSubContent_Lt();

    /**
     * The meta object literal for the '{@link LhsGtRhsImpl <em>Lhs Gt Rhs</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see LhsGtRhsImpl
     * @see WreslEditorPackageImpl#getLhsGtRhs()
     * @generated
     */
    EClass LHS_GT_RHS = eINSTANCE.getLhsGtRhs();

    /**
     * The meta object literal for the '<em><b>Penalty</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LHS_GT_RHS__PENALTY = eINSTANCE.getLhsGtRhs_Penalty();

    /**
     * The meta object literal for the '{@link LhsLtRhsImpl <em>Lhs Lt Rhs</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see LhsLtRhsImpl
     * @see WreslEditorPackageImpl#getLhsLtRhs()
     * @generated
     */
    EClass LHS_LT_RHS = eINSTANCE.getLhsLtRhs();

    /**
     * The meta object literal for the '<em><b>Penalty</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LHS_LT_RHS__PENALTY = eINSTANCE.getLhsLtRhs_Penalty();

    /**
     * The meta object literal for the '{@link PenaltyImpl <em>Penalty</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see PenaltyImpl
     * @see WreslEditorPackageImpl#getPenalty()
     * @generated
     */
    EClass PENALTY = eINSTANCE.getPenalty();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PENALTY__EXPRESSION = eINSTANCE.getPenalty_Expression();

    /**
     * The meta object literal for the '{@link GoalSimpleImpl <em>Goal Simple</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see GoalSimpleImpl
     * @see WreslEditorPackageImpl#getGoalSimple()
     * @generated
     */
    EClass GOAL_SIMPLE = eINSTANCE.getGoalSimple();

    /**
     * The meta object literal for the '<em><b>Constraint</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GOAL_SIMPLE__CONSTRAINT = eINSTANCE.getGoalSimple_Constraint();

    /**
     * The meta object literal for the '{@link ConstraintImpl <em>Constraint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ConstraintImpl
     * @see WreslEditorPackageImpl#getConstraint()
     * @generated
     */
    EClass CONSTRAINT = eINSTANCE.getConstraint();

    /**
     * The meta object literal for the '<em><b>Lhs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSTRAINT__LHS = eINSTANCE.getConstraint_Lhs();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONSTRAINT__OPERATOR = eINSTANCE.getConstraint_Operator();

    /**
     * The meta object literal for the '<em><b>Rhs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSTRAINT__RHS = eINSTANCE.getConstraint_Rhs();

    /**
     * The meta object literal for the '{@link GroupImpl <em>Group</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see GroupImpl
     * @see WreslEditorPackageImpl#getGroup()
     * @generated
     */
    EClass GROUP = eINSTANCE.getGroup();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GROUP__NAME = eINSTANCE.getGroup_Name();

    /**
     * The meta object literal for the '<em><b>Pattern</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GROUP__PATTERN = eINSTANCE.getGroup_Pattern();

    /**
     * The meta object literal for the '<em><b>Ifincitems</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GROUP__IFINCITEMS = eINSTANCE.getGroup_Ifincitems();

    /**
     * The meta object literal for the '{@link ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ModelImpl
     * @see WreslEditorPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__NAME = eINSTANCE.getModel_Name();

    /**
     * The meta object literal for the '<em><b>Pattern</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__PATTERN = eINSTANCE.getModel_Pattern();

    /**
     * The meta object literal for the '<em><b>Ifincitems</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__IFINCITEMS = eINSTANCE.getModel_Ifincitems();

    /**
     * The meta object literal for the '{@link InitialImpl <em>Initial</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see InitialImpl
     * @see WreslEditorPackageImpl#getInitial()
     * @generated
     */
    EClass INITIAL = eINSTANCE.getInitial();

    /**
     * The meta object literal for the '<em><b>Pattern</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INITIAL__PATTERN = eINSTANCE.getInitial_Pattern();

    /**
     * The meta object literal for the '{@link SequenceImpl <em>Sequence</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see SequenceImpl
     * @see WreslEditorPackageImpl#getSequence()
     * @generated
     */
    EClass SEQUENCE = eINSTANCE.getSequence();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SEQUENCE__NAME = eINSTANCE.getSequence_Name();

    /**
     * The meta object literal for the '<em><b>Model</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SEQUENCE__MODEL = eINSTANCE.getSequence_Model();

    /**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SEQUENCE__CONDITION = eINSTANCE.getSequence_Condition();

    /**
     * The meta object literal for the '<em><b>Order</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SEQUENCE__ORDER = eINSTANCE.getSequence_Order();

    /**
     * The meta object literal for the '{@link ConditionImpl <em>Condition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ConditionImpl
     * @see WreslEditorPackageImpl#getCondition()
     * @generated
     */
    EClass CONDITION = eINSTANCE.getCondition();

    /**
     * The meta object literal for the '<em><b>Logical</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITION__LOGICAL = eINSTANCE.getCondition_Logical();

    /**
     * The meta object literal for the '{@link LogicalExpressionImpl <em>Logical Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see LogicalExpressionImpl
     * @see WreslEditorPackageImpl#getLogicalExpression()
     * @generated
     */
    EClass LOGICAL_EXPRESSION = eINSTANCE.getLogicalExpression();

    /**
     * The meta object literal for the '<em><b>C1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOGICAL_EXPRESSION__C1 = eINSTANCE.getLogicalExpression_C1();

    /**
     * The meta object literal for the '<em><b>C2</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOGICAL_EXPRESSION__C2 = eINSTANCE.getLogicalExpression_C2();

    /**
     * The meta object literal for the '{@link ConditionalUnaryImpl <em>Conditional Unary</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ConditionalUnaryImpl
     * @see WreslEditorPackageImpl#getConditionalUnary()
     * @generated
     */
    EClass CONDITIONAL_UNARY = eINSTANCE.getConditionalUnary();

    /**
     * The meta object literal for the '{@link ConditionalTermImpl <em>Conditional Term</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ConditionalTermImpl
     * @see WreslEditorPackageImpl#getConditionalTerm()
     * @generated
     */
    EClass CONDITIONAL_TERM = eINSTANCE.getConditionalTerm();

    /**
     * The meta object literal for the '<em><b>E1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL_TERM__E1 = eINSTANCE.getConditionalTerm_E1();

    /**
     * The meta object literal for the '<em><b>E2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL_TERM__E2 = eINSTANCE.getConditionalTerm_E2();

    /**
     * The meta object literal for the '{@link ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ExpressionImpl
     * @see WreslEditorPackageImpl#getExpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getExpression();

    /**
     * The meta object literal for the '{@link AddImpl <em>Add</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see AddImpl
     * @see WreslEditorPackageImpl#getAdd()
     * @generated
     */
    EClass ADD = eINSTANCE.getAdd();

    /**
     * The meta object literal for the '<em><b>M1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ADD__M1 = eINSTANCE.getAdd_M1();

    /**
     * The meta object literal for the '<em><b>M2</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ADD__M2 = eINSTANCE.getAdd_M2();

    /**
     * The meta object literal for the '{@link MultiplyImpl <em>Multiply</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see MultiplyImpl
     * @see WreslEditorPackageImpl#getMultiply()
     * @generated
     */
    EClass MULTIPLY = eINSTANCE.getMultiply();

    /**
     * The meta object literal for the '<em><b>U1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTIPLY__U1 = eINSTANCE.getMultiply_U1();

    /**
     * The meta object literal for the '<em><b>U2</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTIPLY__U2 = eINSTANCE.getMultiply_U2();

    /**
     * The meta object literal for the '{@link UnaryImpl <em>Unary</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see UnaryImpl
     * @see WreslEditorPackageImpl#getUnary()
     * @generated
     */
    EClass UNARY = eINSTANCE.getUnary();

    /**
     * The meta object literal for the '{@link TermImpl <em>Term</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see TermImpl
     * @see WreslEditorPackageImpl#getTerm()
     * @generated
     */
    EClass TERM = eINSTANCE.getTerm();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TERM__REF = eINSTANCE.getTerm_Ref();

    /**
     * The meta object literal for the '<em><b>N</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TERM__N = eINSTANCE.getTerm_N();

    /**
     * The meta object literal for the '<em><b>F</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TERM__F = eINSTANCE.getTerm_F();

    /**
     * The meta object literal for the '<em><b>E</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TERM__E = eINSTANCE.getTerm_E();

    /**
     * The meta object literal for the '<em><b>S</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TERM__S = eINSTANCE.getTerm_S();

    /**
     * The meta object literal for the '{@link FunctionImpl <em>Function</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see FunctionImpl
     * @see WreslEditorPackageImpl#getFunction()
     * @generated
     */
    EClass FUNCTION = eINSTANCE.getFunction();

    /**
     * The meta object literal for the '{@link ExternalFunction1Impl <em>External Function1</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ExternalFunction1Impl
     * @see WreslEditorPackageImpl#getExternalFunction1()
     * @generated
     */
    EClass EXTERNAL_FUNCTION1 = eINSTANCE.getExternalFunction1();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXTERNAL_FUNCTION1__REF = eINSTANCE.getExternalFunction1_Ref();

    /**
     * The meta object literal for the '<em><b>E1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXTERNAL_FUNCTION1__E1 = eINSTANCE.getExternalFunction1_E1();

    /**
     * The meta object literal for the '<em><b>E2</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXTERNAL_FUNCTION1__E2 = eINSTANCE.getExternalFunction1_E2();

    /**
     * The meta object literal for the '<em><b>E0</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXTERNAL_FUNCTION1__E0 = eINSTANCE.getExternalFunction1_E0();

    /**
     * The meta object literal for the '{@link ExternalFunction2Impl <em>External Function2</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ExternalFunction2Impl
     * @see WreslEditorPackageImpl#getExternalFunction2()
     * @generated
     */
    EClass EXTERNAL_FUNCTION2 = eINSTANCE.getExternalFunction2();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXTERNAL_FUNCTION2__REF = eINSTANCE.getExternalFunction2_Ref();

    /**
     * The meta object literal for the '{@link TrunkTimeArrayImpl <em>Trunk Time Array</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see TrunkTimeArrayImpl
     * @see WreslEditorPackageImpl#getTrunkTimeArray()
     * @generated
     */
    EClass TRUNK_TIME_ARRAY = eINSTANCE.getTrunkTimeArray();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRUNK_TIME_ARRAY__REF = eINSTANCE.getTrunkTimeArray_Ref();

    /**
     * The meta object literal for the '<em><b>T1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRUNK_TIME_ARRAY__T1 = eINSTANCE.getTrunkTimeArray_T1();

    /**
     * The meta object literal for the '<em><b>T2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRUNK_TIME_ARRAY__T2 = eINSTANCE.getTrunkTimeArray_T2();

    /**
     * The meta object literal for the '{@link TrunkTimeArrayIndexImpl <em>Trunk Time Array Index</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see TrunkTimeArrayIndexImpl
     * @see WreslEditorPackageImpl#getTrunkTimeArrayIndex()
     * @generated
     */
    EClass TRUNK_TIME_ARRAY_INDEX = eINSTANCE.getTrunkTimeArrayIndex();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRUNK_TIME_ARRAY_INDEX__REF = eINSTANCE.getTrunkTimeArrayIndex_Ref();

    /**
     * The meta object literal for the '{@link MaxFunctionImpl <em>Max Function</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see MaxFunctionImpl
     * @see WreslEditorPackageImpl#getMaxFunction()
     * @generated
     */
    EClass MAX_FUNCTION = eINSTANCE.getMaxFunction();

    /**
     * The meta object literal for the '<em><b>E1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MAX_FUNCTION__E1 = eINSTANCE.getMaxFunction_E1();

    /**
     * The meta object literal for the '<em><b>E2</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MAX_FUNCTION__E2 = eINSTANCE.getMaxFunction_E2();

    /**
     * The meta object literal for the '{@link MinFunctionImpl <em>Min Function</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see MinFunctionImpl
     * @see WreslEditorPackageImpl#getMinFunction()
     * @generated
     */
    EClass MIN_FUNCTION = eINSTANCE.getMinFunction();

    /**
     * The meta object literal for the '<em><b>E1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MIN_FUNCTION__E1 = eINSTANCE.getMinFunction_E1();

    /**
     * The meta object literal for the '<em><b>E2</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MIN_FUNCTION__E2 = eINSTANCE.getMinFunction_E2();

    /**
     * The meta object literal for the '{@link ModFunctionImpl <em>Mod Function</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ModFunctionImpl
     * @see WreslEditorPackageImpl#getModFunction()
     * @generated
     */
    EClass MOD_FUNCTION = eINSTANCE.getModFunction();

    /**
     * The meta object literal for the '<em><b>E1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MOD_FUNCTION__E1 = eINSTANCE.getModFunction_E1();

    /**
     * The meta object literal for the '<em><b>E2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MOD_FUNCTION__E2 = eINSTANCE.getModFunction_E2();

    /**
     * The meta object literal for the '{@link IntFunctionImpl <em>Int Function</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see IntFunctionImpl
     * @see WreslEditorPackageImpl#getIntFunction()
     * @generated
     */
    EClass INT_FUNCTION = eINSTANCE.getIntFunction();

    /**
     * The meta object literal for the '<em><b>E</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INT_FUNCTION__E = eINSTANCE.getIntFunction_E();

    /**
     * The meta object literal for the '{@link AbsFunctionImpl <em>Abs Function</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see AbsFunctionImpl
     * @see WreslEditorPackageImpl#getAbsFunction()
     * @generated
     */
    EClass ABS_FUNCTION = eINSTANCE.getAbsFunction();

    /**
     * The meta object literal for the '<em><b>E</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ABS_FUNCTION__E = eINSTANCE.getAbsFunction_E();

    /**
     * The meta object literal for the '{@link RoundFunctionImpl <em>Round Function</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see RoundFunctionImpl
     * @see WreslEditorPackageImpl#getRoundFunction()
     * @generated
     */
    EClass ROUND_FUNCTION = eINSTANCE.getRoundFunction();

    /**
     * The meta object literal for the '<em><b>E</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ROUND_FUNCTION__E = eINSTANCE.getRoundFunction_E();

    /**
     * The meta object literal for the '{@link PowFunctionImpl <em>Pow Function</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see PowFunctionImpl
     * @see WreslEditorPackageImpl#getPowFunction()
     * @generated
     */
    EClass POW_FUNCTION = eINSTANCE.getPowFunction();

    /**
     * The meta object literal for the '<em><b>E1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference POW_FUNCTION__E1 = eINSTANCE.getPowFunction_E1();

    /**
     * The meta object literal for the '<em><b>E2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference POW_FUNCTION__E2 = eINSTANCE.getPowFunction_E2();

    /**
     * The meta object literal for the '{@link LogFunctionImpl <em>Log Function</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see LogFunctionImpl
     * @see WreslEditorPackageImpl#getLogFunction()
     * @generated
     */
    EClass LOG_FUNCTION = eINSTANCE.getLogFunction();

    /**
     * The meta object literal for the '<em><b>E</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOG_FUNCTION__E = eINSTANCE.getLogFunction_E();

    /**
     * The meta object literal for the '{@link SinFunctionImpl <em>Sin Function</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see SinFunctionImpl
     * @see WreslEditorPackageImpl#getSinFunction()
     * @generated
     */
    EClass SIN_FUNCTION = eINSTANCE.getSinFunction();

    /**
     * The meta object literal for the '<em><b>E</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SIN_FUNCTION__E = eINSTANCE.getSinFunction_E();

    /**
     * The meta object literal for the '{@link CosFunctionImpl <em>Cos Function</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see CosFunctionImpl
     * @see WreslEditorPackageImpl#getCosFunction()
     * @generated
     */
    EClass COS_FUNCTION = eINSTANCE.getCosFunction();

    /**
     * The meta object literal for the '<em><b>E</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COS_FUNCTION__E = eINSTANCE.getCosFunction_E();

    /**
     * The meta object literal for the '{@link TanFunctionImpl <em>Tan Function</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see TanFunctionImpl
     * @see WreslEditorPackageImpl#getTanFunction()
     * @generated
     */
    EClass TAN_FUNCTION = eINSTANCE.getTanFunction();

    /**
     * The meta object literal for the '<em><b>E</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TAN_FUNCTION__E = eINSTANCE.getTanFunction_E();

    /**
     * The meta object literal for the '{@link CotFunctionImpl <em>Cot Function</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see CotFunctionImpl
     * @see WreslEditorPackageImpl#getCotFunction()
     * @generated
     */
    EClass COT_FUNCTION = eINSTANCE.getCotFunction();

    /**
     * The meta object literal for the '<em><b>E</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COT_FUNCTION__E = eINSTANCE.getCotFunction_E();

    /**
     * The meta object literal for the '{@link AsinFunctionImpl <em>Asin Function</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see AsinFunctionImpl
     * @see WreslEditorPackageImpl#getAsinFunction()
     * @generated
     */
    EClass ASIN_FUNCTION = eINSTANCE.getAsinFunction();

    /**
     * The meta object literal for the '<em><b>E</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASIN_FUNCTION__E = eINSTANCE.getAsinFunction_E();

    /**
     * The meta object literal for the '{@link AcosFunctionImpl <em>Acos Function</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see AcosFunctionImpl
     * @see WreslEditorPackageImpl#getAcosFunction()
     * @generated
     */
    EClass ACOS_FUNCTION = eINSTANCE.getAcosFunction();

    /**
     * The meta object literal for the '<em><b>E</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACOS_FUNCTION__E = eINSTANCE.getAcosFunction_E();

    /**
     * The meta object literal for the '{@link AtanFunctionImpl <em>Atan Function</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see AtanFunctionImpl
     * @see WreslEditorPackageImpl#getAtanFunction()
     * @generated
     */
    EClass ATAN_FUNCTION = eINSTANCE.getAtanFunction();

    /**
     * The meta object literal for the '<em><b>E</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATAN_FUNCTION__E = eINSTANCE.getAtanFunction_E();

    /**
     * The meta object literal for the '{@link AcotFunctionImpl <em>Acot Function</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see AcotFunctionImpl
     * @see WreslEditorPackageImpl#getAcotFunction()
     * @generated
     */
    EClass ACOT_FUNCTION = eINSTANCE.getAcotFunction();

    /**
     * The meta object literal for the '<em><b>E</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACOT_FUNCTION__E = eINSTANCE.getAcotFunction_E();

    /**
     * The meta object literal for the '{@link VarModelImpl <em>Var Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see VarModelImpl
     * @see WreslEditorPackageImpl#getVarModel()
     * @generated
     */
    EClass VAR_MODEL = eINSTANCE.getVarModel();

    /**
     * The meta object literal for the '<em><b>Ref1</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VAR_MODEL__REF1 = eINSTANCE.getVarModel_Ref1();

    /**
     * The meta object literal for the '<em><b>Ref2</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VAR_MODEL__REF2 = eINSTANCE.getVarModel_Ref2();

    /**
     * The meta object literal for the '{@link VarModelStepImpl <em>Var Model Step</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see VarModelStepImpl
     * @see WreslEditorPackageImpl#getVarModelStep()
     * @generated
     */
    EClass VAR_MODEL_STEP = eINSTANCE.getVarModelStep();

    /**
     * The meta object literal for the '<em><b>Ref1</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VAR_MODEL_STEP__REF1 = eINSTANCE.getVarModelStep_Ref1();

    /**
     * The meta object literal for the '<em><b>Ref2</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VAR_MODEL_STEP__REF2 = eINSTANCE.getVarModelStep_Ref2();

    /**
     * The meta object literal for the '<em><b>E</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VAR_MODEL_STEP__E = eINSTANCE.getVarModelStep_E();

    /**
     * The meta object literal for the '{@link VarModelIndexImpl <em>Var Model Index</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see VarModelIndexImpl
     * @see WreslEditorPackageImpl#getVarModelIndex()
     * @generated
     */
    EClass VAR_MODEL_INDEX = eINSTANCE.getVarModelIndex();

    /**
     * The meta object literal for the '<em><b>Ref1</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VAR_MODEL_INDEX__REF1 = eINSTANCE.getVarModelIndex_Ref1();

    /**
     * The meta object literal for the '{@link VarModelIndexStepImpl <em>Var Model Index Step</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see VarModelIndexStepImpl
     * @see WreslEditorPackageImpl#getVarModelIndexStep()
     * @generated
     */
    EClass VAR_MODEL_INDEX_STEP = eINSTANCE.getVarModelIndexStep();

    /**
     * The meta object literal for the '<em><b>Ref1</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VAR_MODEL_INDEX_STEP__REF1 = eINSTANCE.getVarModelIndexStep_Ref1();

    /**
     * The meta object literal for the '<em><b>E</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VAR_MODEL_INDEX_STEP__E = eINSTANCE.getVarModelIndexStep_E();

    /**
     * The meta object literal for the '{@link IdentImpl <em>Ident</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see IdentImpl
     * @see WreslEditorPackageImpl#getIdent()
     * @generated
     */
    EClass IDENT = eINSTANCE.getIdent();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IDENT__NAME = eINSTANCE.getIdent_Name();

    /**
     * The meta object literal for the '{@link IncludeFileImpl <em>Include File</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see IncludeFileImpl
     * @see WreslEditorPackageImpl#getIncludeFile()
     * @generated
     */
    EClass INCLUDE_FILE = eINSTANCE.getIncludeFile();

    /**
     * The meta object literal for the '<em><b>File</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INCLUDE_FILE__FILE = eINSTANCE.getIncludeFile_File();

  }

} //WreslEditorPackage
