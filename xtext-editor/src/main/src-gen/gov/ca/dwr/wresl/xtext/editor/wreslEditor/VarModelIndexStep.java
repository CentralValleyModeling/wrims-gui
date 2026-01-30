/**
 */
package gov.ca.dwr.wresl.xtext.editor.wreslEditor;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Var Model Index Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link VarModelIndexStep#getRef1 <em>Ref1</em>}</li>
 *   <li>{@link VarModelIndexStep#getE <em>E</em>}</li>
 * </ul>
 * </p>
 *
 * @see WreslEditorPackage#getVarModelIndexStep()
 * @model
 * @generated
 */
public interface VarModelIndexStep extends Function
{
  /**
   * Returns the value of the '<em><b>Ref1</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ref1</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref1</em>' reference.
   * @see #setRef1(Declaration)
   * @see WreslEditorPackage#getVarModelIndexStep_Ref1()
   * @model
   * @generated
   */
  Declaration getRef1();

  /**
   * Sets the value of the '{@link VarModelIndexStep#getRef1 <em>Ref1</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref1</em>' reference.
   * @see #getRef1()
   * @generated
   */
  void setRef1(Declaration value);

  /**
   * Returns the value of the '<em><b>E</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>E</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>E</em>' containment reference.
   * @see #setE(Expression)
   * @see WreslEditorPackage#getVarModelIndexStep_E()
   * @model containment="true"
   * @generated
   */
  Expression getE();

  /**
   * Sets the value of the '{@link VarModelIndexStep#getE <em>E</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>E</em>' containment reference.
   * @see #getE()
   * @generated
   */
  void setE(Expression value);

} // VarModelIndexStep
