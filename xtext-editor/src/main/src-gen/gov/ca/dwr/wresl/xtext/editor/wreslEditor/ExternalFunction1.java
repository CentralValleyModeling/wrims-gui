/**
 */
package gov.ca.dwr.wresl.xtext.editor.wreslEditor;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>External Function1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ExternalFunction1#getRef <em>Ref</em>}</li>
 *   <li>{@link ExternalFunction1#getE1 <em>E1</em>}</li>
 *   <li>{@link ExternalFunction1#getE2 <em>E2</em>}</li>
 *   <li>{@link ExternalFunction1#getE0 <em>E0</em>}</li>
 * </ul>
 * </p>
 *
 * @see WreslEditorPackage#getExternalFunction1()
 * @model
 * @generated
 */
public interface ExternalFunction1 extends Function
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
   * @see WreslEditorPackage#getExternalFunction1_Ref()
   * @model
   * @generated
   */
  Declaration getRef();

  /**
   * Sets the value of the '{@link ExternalFunction1#getRef <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' reference.
   * @see #getRef()
   * @generated
   */
  void setRef(Declaration value);

  /**
   * Returns the value of the '<em><b>E1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>E1</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>E1</em>' containment reference.
   * @see #setE1(EObject)
   * @see WreslEditorPackage#getExternalFunction1_E1()
   * @model containment="true"
   * @generated
   */
  EObject getE1();

  /**
   * Sets the value of the '{@link ExternalFunction1#getE1 <em>E1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>E1</em>' containment reference.
   * @see #getE1()
   * @generated
   */
  void setE1(EObject value);

  /**
   * Returns the value of the '<em><b>E2</b></em>' containment reference list.
   * The list contents are of type {@link EObject}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>E2</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>E2</em>' containment reference list.
   * @see WreslEditorPackage#getExternalFunction1_E2()
   * @model containment="true"
   * @generated
   */
  EList<EObject> getE2();

  /**
   * Returns the value of the '<em><b>E0</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>E0</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>E0</em>' containment reference.
   * @see #setE0(Expression)
   * @see WreslEditorPackage#getExternalFunction1_E0()
   * @model containment="true"
   * @generated
   */
  Expression getE0();

  /**
   * Sets the value of the '{@link ExternalFunction1#getE0 <em>E0</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>E0</em>' containment reference.
   * @see #getE0()
   * @generated
   */
  void setE0(Expression value);

} // ExternalFunction1
