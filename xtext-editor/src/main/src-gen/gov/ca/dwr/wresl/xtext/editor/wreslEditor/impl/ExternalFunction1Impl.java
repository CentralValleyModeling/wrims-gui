/**
 */
package gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl;

import gov.ca.dwr.wresl.xtext.editor.wreslEditor.Declaration;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.Expression;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.ExternalFunction1;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.WreslEditorPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>External Function1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ExternalFunction1Impl#getRef <em>Ref</em>}</li>
 *   <li>{@link ExternalFunction1Impl#getE1 <em>E1</em>}</li>
 *   <li>{@link ExternalFunction1Impl#getE2 <em>E2</em>}</li>
 *   <li>{@link ExternalFunction1Impl#getE0 <em>E0</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExternalFunction1Impl extends FunctionImpl implements ExternalFunction1
{
  /**
   * The cached value of the '{@link #getRef() <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRef()
   * @generated
   * @ordered
   */
  protected Declaration ref;

  /**
   * The cached value of the '{@link #getE1() <em>E1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getE1()
   * @generated
   * @ordered
   */
  protected EObject e1;

  /**
   * The cached value of the '{@link #getE2() <em>E2</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getE2()
   * @generated
   * @ordered
   */
  protected EList<EObject> e2;

  /**
   * The cached value of the '{@link #getE0() <em>E0</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getE0()
   * @generated
   * @ordered
   */
  protected Expression e0;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExternalFunction1Impl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return WreslEditorPackage.Literals.EXTERNAL_FUNCTION1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Declaration getRef()
  {
    if (ref != null && ref.eIsProxy())
    {
      InternalEObject oldRef = (InternalEObject)ref;
      ref = (Declaration)eResolveProxy(oldRef);
      if (ref != oldRef)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, WreslEditorPackage.EXTERNAL_FUNCTION1__REF, oldRef, ref));
      }
    }
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Declaration basicGetRef()
  {
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRef(Declaration newRef)
  {
    Declaration oldRef = ref;
    ref = newRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, WreslEditorPackage.EXTERNAL_FUNCTION1__REF, oldRef, ref));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject getE1()
  {
    return e1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetE1(EObject newE1, NotificationChain msgs)
  {
    EObject oldE1 = e1;
    e1 = newE1;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WreslEditorPackage.EXTERNAL_FUNCTION1__E1, oldE1, newE1);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setE1(EObject newE1)
  {
    if (newE1 != e1)
    {
      NotificationChain msgs = null;
      if (e1 != null)
        msgs = ((InternalEObject)e1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WreslEditorPackage.EXTERNAL_FUNCTION1__E1, null, msgs);
      if (newE1 != null)
        msgs = ((InternalEObject)newE1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WreslEditorPackage.EXTERNAL_FUNCTION1__E1, null, msgs);
      msgs = basicSetE1(newE1, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, WreslEditorPackage.EXTERNAL_FUNCTION1__E1, newE1, newE1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EObject> getE2()
  {
    if (e2 == null)
    {
      e2 = new EObjectContainmentEList<EObject>(EObject.class, this, WreslEditorPackage.EXTERNAL_FUNCTION1__E2);
    }
    return e2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getE0()
  {
    return e0;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetE0(Expression newE0, NotificationChain msgs)
  {
    Expression oldE0 = e0;
    e0 = newE0;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WreslEditorPackage.EXTERNAL_FUNCTION1__E0, oldE0, newE0);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setE0(Expression newE0)
  {
    if (newE0 != e0)
    {
      NotificationChain msgs = null;
      if (e0 != null)
        msgs = ((InternalEObject)e0).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WreslEditorPackage.EXTERNAL_FUNCTION1__E0, null, msgs);
      if (newE0 != null)
        msgs = ((InternalEObject)newE0).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WreslEditorPackage.EXTERNAL_FUNCTION1__E0, null, msgs);
      msgs = basicSetE0(newE0, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, WreslEditorPackage.EXTERNAL_FUNCTION1__E0, newE0, newE0));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case WreslEditorPackage.EXTERNAL_FUNCTION1__E1:
        return basicSetE1(null, msgs);
      case WreslEditorPackage.EXTERNAL_FUNCTION1__E2:
        return ((InternalEList<?>)getE2()).basicRemove(otherEnd, msgs);
      case WreslEditorPackage.EXTERNAL_FUNCTION1__E0:
        return basicSetE0(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case WreslEditorPackage.EXTERNAL_FUNCTION1__REF:
        if (resolve) return getRef();
        return basicGetRef();
      case WreslEditorPackage.EXTERNAL_FUNCTION1__E1:
        return getE1();
      case WreslEditorPackage.EXTERNAL_FUNCTION1__E2:
        return getE2();
      case WreslEditorPackage.EXTERNAL_FUNCTION1__E0:
        return getE0();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case WreslEditorPackage.EXTERNAL_FUNCTION1__REF:
        setRef((Declaration)newValue);
        return;
      case WreslEditorPackage.EXTERNAL_FUNCTION1__E1:
        setE1((EObject)newValue);
        return;
      case WreslEditorPackage.EXTERNAL_FUNCTION1__E2:
        getE2().clear();
        getE2().addAll((Collection<? extends EObject>)newValue);
        return;
      case WreslEditorPackage.EXTERNAL_FUNCTION1__E0:
        setE0((Expression)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case WreslEditorPackage.EXTERNAL_FUNCTION1__REF:
        setRef((Declaration)null);
        return;
      case WreslEditorPackage.EXTERNAL_FUNCTION1__E1:
        setE1((EObject)null);
        return;
      case WreslEditorPackage.EXTERNAL_FUNCTION1__E2:
        getE2().clear();
        return;
      case WreslEditorPackage.EXTERNAL_FUNCTION1__E0:
        setE0((Expression)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case WreslEditorPackage.EXTERNAL_FUNCTION1__REF:
        return ref != null;
      case WreslEditorPackage.EXTERNAL_FUNCTION1__E1:
        return e1 != null;
      case WreslEditorPackage.EXTERNAL_FUNCTION1__E2:
        return e2 != null && !e2.isEmpty();
      case WreslEditorPackage.EXTERNAL_FUNCTION1__E0:
        return e0 != null;
    }
    return super.eIsSet(featureID);
  }

} //ExternalFunction1Impl
