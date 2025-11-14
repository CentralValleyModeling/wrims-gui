/**
 */
package gov.ca.water.wresl.xtext.editor.wreslEditor;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Model#getName <em>Name</em>}</li>
 *   <li>{@link Model#getPattern <em>Pattern</em>}</li>
 *   <li>{@link Model#getIfincitems <em>Ifincitems</em>}</li>
 * </ul>
 * </p>
 *
 * @see WreslEditorPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see WreslEditorPackage#getModel_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link Model#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

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
   * @see WreslEditorPackage#getModel_Pattern()
   * @model containment="true"
   * @generated
   */
  EList<Pattern> getPattern();

  /**
   * Returns the value of the '<em><b>Ifincitems</b></em>' containment reference list.
   * The list contents are of type {@link IfIncItems}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ifincitems</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ifincitems</em>' containment reference list.
   * @see WreslEditorPackage#getModel_Ifincitems()
   * @model containment="true"
   * @generated
   */
  EList<IfIncItems> getIfincitems();

} // Model
