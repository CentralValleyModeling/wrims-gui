/**
 */
package gov.ca.dwr.wresl.xtext.editor.wreslEditor;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Wresl Evaluator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link WreslEvaluator#getPattern <em>Pattern</em>}</li>
 *   <li>{@link WreslEvaluator#getIfincitem <em>Ifincitem</em>}</li>
 *   <li>{@link WreslEvaluator#getInitial <em>Initial</em>}</li>
 *   <li>{@link WreslEvaluator#getSequence <em>Sequence</em>}</li>
 *   <li>{@link WreslEvaluator#getModel <em>Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see WreslEditorPackage#getWreslEvaluator()
 * @model
 * @generated
 */
public interface WreslEvaluator extends EObject
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
   * @see WreslEditorPackage#getWreslEvaluator_Pattern()
   * @model containment="true"
   * @generated
   */
  EList<Pattern> getPattern();

  /**
   * Returns the value of the '<em><b>Ifincitem</b></em>' containment reference list.
   * The list contents are of type {@link IfIncItems}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ifincitem</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ifincitem</em>' containment reference list.
   * @see WreslEditorPackage#getWreslEvaluator_Ifincitem()
   * @model containment="true"
   * @generated
   */
  EList<IfIncItems> getIfincitem();

  /**
   * Returns the value of the '<em><b>Initial</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Initial</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Initial</em>' containment reference.
   * @see #setInitial(Initial)
   * @see WreslEditorPackage#getWreslEvaluator_Initial()
   * @model containment="true"
   * @generated
   */
  Initial getInitial();

  /**
   * Sets the value of the '{@link WreslEvaluator#getInitial <em>Initial</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Initial</em>' containment reference.
   * @see #getInitial()
   * @generated
   */
  void setInitial(Initial value);

  /**
   * Returns the value of the '<em><b>Sequence</b></em>' containment reference list.
   * The list contents are of type {@link Sequence}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sequence</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sequence</em>' containment reference list.
   * @see WreslEditorPackage#getWreslEvaluator_Sequence()
   * @model containment="true"
   * @generated
   */
  EList<Sequence> getSequence();

  /**
   * Returns the value of the '<em><b>Model</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Model</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Model</em>' containment reference list.
   * @see WreslEditorPackage#getWreslEvaluator_Model()
   * @model containment="true"
   * @generated
   */
  EList<EObject> getModel();

} // WreslEvaluator
