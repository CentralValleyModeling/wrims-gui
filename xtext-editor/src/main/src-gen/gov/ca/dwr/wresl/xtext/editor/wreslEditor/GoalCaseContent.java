/**
 */
package gov.ca.dwr.wresl.xtext.editor.wreslEditor;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Goal Case Content</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link GoalCaseContent#getCaseName <em>Case Name</em>}</li>
 *   <li>{@link GoalCaseContent#getCondition <em>Condition</em>}</li>
 *   <li>{@link GoalCaseContent#getRhs <em>Rhs</em>}</li>
 *   <li>{@link GoalCaseContent#getSubContent <em>Sub Content</em>}</li>
 * </ul>
 * </p>
 *
 * @see WreslEditorPackage#getGoalCaseContent()
 * @model
 * @generated
 */
public interface GoalCaseContent extends EObject
{
  /**
   * Returns the value of the '<em><b>Case Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Case Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Case Name</em>' attribute.
   * @see #setCaseName(String)
   * @see WreslEditorPackage#getGoalCaseContent_CaseName()
   * @model
   * @generated
   */
  String getCaseName();

  /**
   * Sets the value of the '{@link GoalCaseContent#getCaseName <em>Case Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Case Name</em>' attribute.
   * @see #getCaseName()
   * @generated
   */
  void setCaseName(String value);

  /**
   * Returns the value of the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Condition</em>' containment reference.
   * @see #setCondition(Condition)
   * @see WreslEditorPackage#getGoalCaseContent_Condition()
   * @model containment="true"
   * @generated
   */
  Condition getCondition();

  /**
   * Sets the value of the '{@link GoalCaseContent#getCondition <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition</em>' containment reference.
   * @see #getCondition()
   * @generated
   */
  void setCondition(Condition value);

  /**
   * Returns the value of the '<em><b>Rhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rhs</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rhs</em>' containment reference.
   * @see #setRhs(Expression)
   * @see WreslEditorPackage#getGoalCaseContent_Rhs()
   * @model containment="true"
   * @generated
   */
  Expression getRhs();

  /**
   * Sets the value of the '{@link GoalCaseContent#getRhs <em>Rhs</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rhs</em>' containment reference.
   * @see #getRhs()
   * @generated
   */
  void setRhs(Expression value);

  /**
   * Returns the value of the '<em><b>Sub Content</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sub Content</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sub Content</em>' containment reference.
   * @see #setSubContent(SubContent)
   * @see WreslEditorPackage#getGoalCaseContent_SubContent()
   * @model containment="true"
   * @generated
   */
  SubContent getSubContent();

  /**
   * Sets the value of the '{@link GoalCaseContent#getSubContent <em>Sub Content</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sub Content</em>' containment reference.
   * @see #getSubContent()
   * @generated
   */
  void setSubContent(SubContent value);

} // GoalCaseContent
