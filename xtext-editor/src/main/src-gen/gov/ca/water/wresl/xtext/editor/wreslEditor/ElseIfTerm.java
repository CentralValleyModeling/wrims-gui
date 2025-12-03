/**
 */
package gov.ca.water.wresl.xtext.editor.wreslEditor;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Else If Term</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ElseIfTerm#getLogical <em>Logical</em>}</li>
 *   <li>{@link ElseIfTerm#getPattern <em>Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @see WreslEditorPackage#getElseIfTerm()
 * @model
 * @generated
 */
public interface ElseIfTerm extends EObject
{
  /**
   * Returns the value of the '<em><b>Logical</b></em>' containment reference list.
   * The list contents are of type {@link LogicalExpression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Logical</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Logical</em>' containment reference list.
   * @see WreslEditorPackage#getElseIfTerm_Logical()
   * @model containment="true"
   * @generated
   */
  EList<LogicalExpression> getLogical();

  /**
   * Returns the value of the '<em><b>Pattern</b></em>' containment reference list.
   * The list contents are of type {@link Pattern}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Pattern</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Pattern</em>' containment reference list.
   * @see WreslEditorPackage#getElseIfTerm_Pattern()
   * @model containment="true"
   * @generated
   */
  EList<Pattern> getPattern();

} // ElseIfTerm
