/**
 */
package gov.ca.dwr.wresl.xtext.editor.wreslEditor;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trunk Time Array</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link TrunkTimeArray#getRef <em>Ref</em>}</li>
 *   <li>{@link TrunkTimeArray#getT1 <em>T1</em>}</li>
 *   <li>{@link TrunkTimeArray#getT2 <em>T2</em>}</li>
 * </ul>
 * </p>
 *
 * @see WreslEditorPackage#getTrunkTimeArray()
 * @model
 * @generated
 */
public interface TrunkTimeArray extends EObject
{
  /**
   * Returns the value of the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ref</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' reference.
   * @see #setRef(Declaration)
   * @see WreslEditorPackage#getTrunkTimeArray_Ref()
   * @model
   * @generated
   */
  Declaration getRef();

  /**
   * Sets the value of the '{@link TrunkTimeArray#getRef <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' reference.
   * @see #getRef()
   * @generated
   */
  void setRef(Declaration value);

  /**
   * Returns the value of the '<em><b>T1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>T1</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>T1</em>' containment reference.
   * @see #setT1(TrunkTimeArrayIndex)
   * @see WreslEditorPackage#getTrunkTimeArray_T1()
   * @model containment="true"
   * @generated
   */
  TrunkTimeArrayIndex getT1();

  /**
   * Sets the value of the '{@link TrunkTimeArray#getT1 <em>T1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>T1</em>' containment reference.
   * @see #getT1()
   * @generated
   */
  void setT1(TrunkTimeArrayIndex value);

  /**
   * Returns the value of the '<em><b>T2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>T2</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>T2</em>' containment reference.
   * @see #setT2(TrunkTimeArrayIndex)
   * @see WreslEditorPackage#getTrunkTimeArray_T2()
   * @model containment="true"
   * @generated
   */
  TrunkTimeArrayIndex getT2();

  /**
   * Sets the value of the '{@link TrunkTimeArray#getT2 <em>T2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>T2</em>' containment reference.
   * @see #getT2()
   * @generated
   */
  void setT2(TrunkTimeArrayIndex value);

} // TrunkTimeArray
