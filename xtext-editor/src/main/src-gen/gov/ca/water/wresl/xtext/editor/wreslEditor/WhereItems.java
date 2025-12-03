/**
 */
package gov.ca.water.wresl.xtext.editor.wreslEditor;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Where Items</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link WhereItems#getAssignment <em>Assignment</em>}</li>
 * </ul>
 * </p>
 *
 * @see WreslEditorPackage#getWhereItems()
 * @model
 * @generated
 */
public interface WhereItems extends EObject
{
  /**
   * Returns the value of the '<em><b>Assignment</b></em>' containment reference list.
   * The list contents are of type {@link Assignment}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Assignment</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Assignment</em>' containment reference list.
   * @see WreslEditorPackage#getWhereItems_Assignment()
   * @model containment="true"
   * @generated
   */
  EList<Assignment> getAssignment();

} // WhereItems
