/**
 */
package gov.ca.dwr.wresl.xtext.editor.wreslEditor;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Logical Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link LogicalExpression#getC1 <em>C1</em>}</li>
 *   <li>{@link LogicalExpression#getC2 <em>C2</em>}</li>
 * </ul>
 * </p>
 *
 * @see WreslEditorPackage#getLogicalExpression()
 * @model
 * @generated
 */
public interface LogicalExpression extends ConditionalTerm
{
  /**
   * Returns the value of the '<em><b>C1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>C1</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>C1</em>' containment reference.
   * @see #setC1(ConditionalUnary)
   * @see WreslEditorPackage#getLogicalExpression_C1()
   * @model containment="true"
   * @generated
   */
  ConditionalUnary getC1();

  /**
   * Sets the value of the '{@link LogicalExpression#getC1 <em>C1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>C1</em>' containment reference.
   * @see #getC1()
   * @generated
   */
  void setC1(ConditionalUnary value);

  /**
   * Returns the value of the '<em><b>C2</b></em>' containment reference list.
   * The list contents are of type {@link ConditionalUnary}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>C2</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>C2</em>' containment reference list.
   * @see WreslEditorPackage#getLogicalExpression_C2()
   * @model containment="true"
   * @generated
   */
  EList<ConditionalUnary> getC2();

} // LogicalExpression
