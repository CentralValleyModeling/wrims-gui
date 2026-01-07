/**
 */
package gov.ca.dwr.wresl.xtext.editor.wreslEditor;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Initial</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Initial#getPattern <em>Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @see WreslEditorPackage#getInitial()
 * @model
 * @generated
 */
public interface Initial extends EObject
{
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
   * @see WreslEditorPackage#getInitial_Pattern()
   * @model containment="true"
   * @generated
   */
  EList<Pattern> getPattern();

} // Initial
