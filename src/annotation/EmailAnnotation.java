

/* First created by JCasGen Fri Apr 12 21:19:29 IST 2013 */
package annotation;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Sun Apr 14 23:30:43 IST 2013
 * XML source: /home/sridhar/workspace/UIMAwebapp2/desc/emailTypeDescriptor.xml
 * @generated */
public class EmailAnnotation extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(EmailAnnotation.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected EmailAnnotation() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public EmailAnnotation(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public EmailAnnotation(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public EmailAnnotation(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: sentOrReceived

  /** getter for sentOrReceived - gets If 0 then sent email, if 1 then received email.
   * @generated */
  public boolean getSentOrReceived() {
    if (EmailAnnotation_Type.featOkTst && ((EmailAnnotation_Type)jcasType).casFeat_sentOrReceived == null)
      jcasType.jcas.throwFeatMissing("sentOrReceived", "annotation.EmailAnnotation");
    return jcasType.ll_cas.ll_getBooleanValue(addr, ((EmailAnnotation_Type)jcasType).casFeatCode_sentOrReceived);}
    
  /** setter for sentOrReceived - sets If 0 then sent email, if 1 then received email. 
   * @generated */
  public void setSentOrReceived(boolean v) {
    if (EmailAnnotation_Type.featOkTst && ((EmailAnnotation_Type)jcasType).casFeat_sentOrReceived == null)
      jcasType.jcas.throwFeatMissing("sentOrReceived", "annotation.EmailAnnotation");
    jcasType.ll_cas.ll_setBooleanValue(addr, ((EmailAnnotation_Type)jcasType).casFeatCode_sentOrReceived, v);}    
   
    
  //*--------------*
  //* Feature: folderName

  /** getter for folderName - gets Foldername to which this email belongs
   * @generated */
  public String getFolderName() {
    if (EmailAnnotation_Type.featOkTst && ((EmailAnnotation_Type)jcasType).casFeat_folderName == null)
      jcasType.jcas.throwFeatMissing("folderName", "annotation.EmailAnnotation");
    return jcasType.ll_cas.ll_getStringValue(addr, ((EmailAnnotation_Type)jcasType).casFeatCode_folderName);}
    
  /** setter for folderName - sets Foldername to which this email belongs 
   * @generated */
  public void setFolderName(String v) {
    if (EmailAnnotation_Type.featOkTst && ((EmailAnnotation_Type)jcasType).casFeat_folderName == null)
      jcasType.jcas.throwFeatMissing("folderName", "annotation.EmailAnnotation");
    jcasType.ll_cas.ll_setStringValue(addr, ((EmailAnnotation_Type)jcasType).casFeatCode_folderName, v);}    
   
    
  //*--------------*
  //* Feature: category

  /** getter for category - gets Could be a meeting request or appointment or issue or newsletter
   * @generated */
  public String getCategory() {
    if (EmailAnnotation_Type.featOkTst && ((EmailAnnotation_Type)jcasType).casFeat_category == null)
      jcasType.jcas.throwFeatMissing("category", "annotation.EmailAnnotation");
    return jcasType.ll_cas.ll_getStringValue(addr, ((EmailAnnotation_Type)jcasType).casFeatCode_category);}
    
  /** setter for category - sets Could be a meeting request or appointment or issue or newsletter 
   * @generated */
  public void setCategory(String v) {
    if (EmailAnnotation_Type.featOkTst && ((EmailAnnotation_Type)jcasType).casFeat_category == null)
      jcasType.jcas.throwFeatMissing("category", "annotation.EmailAnnotation");
    jcasType.ll_cas.ll_setStringValue(addr, ((EmailAnnotation_Type)jcasType).casFeatCode_category, v);}    
  }

    