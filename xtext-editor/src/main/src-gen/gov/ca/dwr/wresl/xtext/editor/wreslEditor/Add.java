/**
 */
package gov.ca.dwr.wresl.xtext.editor.wreslEditor;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Add</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Add#getM1 <em>M1</em>}</li>
 *   <li>{@link Add#getM2 <em>M2</em>}</li>
 * </ul>
 * </p>
 *
 * @see WreslEditorPackage#getAdd()
 * @model
 * @generated
 */
public interface Add extends Expression
{
  /**
   * Returns the value of the '<em><b>M1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>M1</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>M1</em>' containment reference.
   * @see #setM1(Multiply)
   * @see WreslEditorPackage#getAdd_M1()
   * @model containment="true"
   * @generated
   */
  Multiply getM1();

  /**
   * Sets the value of the '{@link Add#getM1 <em>M1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>M1</em>' containment reference.
   * @see #getM1()
   * @generated
   */
  void setM1(Multiply value);

  /**
   * Returns the value of the '<em><b>M2</b></em>' containment reference list.
   * The list contents are of type {@link Multiply}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>M2</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>M2</em>' containment reference list.
   * @see WreslEditorPackage#getAdd_M2()
   * @model containment="true"
   * @generated
   */
  EList<Multiply> getM2();

} // Add
