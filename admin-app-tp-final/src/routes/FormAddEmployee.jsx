import { useRef } from "react"
import { useDispatch } from "react-redux"
import { useNavigate } from "react-router-dom"
import styles from "../style/styleForm.module.css"

const AddEmployeeForm = () => {
    const dispatch = useDispatch()
    const navigate = useNavigate()
    // const mode = useSelector(state => state.employees.formMode)
    // const employee = useSelector(state => state.employees.selectedEmployee)
    const employee = null

    const lastNameRef = useRef()
    const firstNameRef = useRef()
    const birthDateRef = useRef()
    const genreRef = useRef()
    const addressNumberRef = useRef()
    const streetRef = useRef()
    const complementRef = useRef()
    const zipCodeRef = useRef()
    const townRef = useRef()
    const emailRef = useRef()
    const roleRef = useRef()


    const submitHandler = (event) => {
        event.preventDefault()

        const lastName = lastNameRef.current.value
        const firstName = firstNameRef.current.value
        const birthDate = birthDateRef.current.value
        const genre = genreRef.current.value
        const addressNumber = addressNumberRef.current.value
        const street = streetRef.current.value
        const complement = complementRef.current.value
        const zipCode = zipCodeRef.current.value
        const town = townRef.current.value
        const email = emailRef.current.value
        const role = roleRef.current.value


        const newEmployeeValues = {
            lastName,
            firstName,
            birthDate,
            genre,
            addressNumber,
            street,
            complement,
            zipCode,
            town,
            email,
            role
        }

        // if (mode === 'add') {
        //     dispatch(addEmployeeAction(newEmployeeValues))
        // } else if (mode === 'edit') {
        //     dispatch(editEmployeeAction({...newEmployeeValues,id: employee.id}))
        // }

        dispatch(setFormMode(""))
        navigate("/")
    }

    return (

    <>
    <h3 className={styles.h3}>
       Formulaire
    </h3>

    <form onSubmit={submitHandler} className={styles.form}>
        <div>
            <label htmlFor="lastName" className={styles.label}>Nom :</label>
            <input type="text" id="lastName" className="form-control" required ref={lastNameRef} defaultValue={employee?.lastName}></input>
        </div>
        <div>
            <label htmlFor="firstName" className={styles.label}>Prénom :</label>
            <input type="text" id="firstName" className="form-control" required ref={firstNameRef} defaultValue={employee?.firstName}></input>
        </div>
        <div>
            <label htmlFor="birthDate" className={styles.label}>Date de naissance :</label>
            <input type="date" id="birthDate" className="form-control" required ref={birthDateRef} defaultValue={employee?.birthDate}></input>
        </div>
        <div>
            <label htmlFor="genre" className={styles.label}>Genre :</label>
            <input type="text" id="genre" className="form-control" required ref={genreRef} defaultValue={employee?.genre}></input>
        </div>
        <div>
            <div>
                <p className={styles.label}>Adresse :</p>
            </div>
            <div>
            <label htmlFor="addressNumber" className={styles.label}>No :</label>
            <input type="number" id="addressNumber" className="form-control" required ref={addressNumberRef} defaultValue={employee?.addressNumber}></input>
            </div>
            <div>
            <label htmlFor="street" className={styles.label}>Rue :</label>
            <input type="text" id="street" className="form-control" required ref={streetRef} defaultValue={employee?.street}></input>
            </div>
            <div>
            <label htmlFor="complement" className={styles.label}>Complément :</label>
            <input type="text" id="complement" className="form-control" required ref={complementRef} defaultValue={employee?.complement}></input>
            </div>
            <div>
            <label htmlFor="zipCode" className={styles.label}>CP :</label>
            <input type="text" id="zipCode" className="form-control" required ref={zipCodeRef} defaultValue={employee?.zipCode}></input>
            </div>
            <div>
            <label htmlFor="town" className={styles.label}>Ville :</label>
            <input type="text" id="town" className="form-control" required ref={townRef} defaultValue={employee?.town}></input>
            </div>
        </div>

        <div>
            <label htmlFor="email" className={styles.label}>Email :</label>
            <input type="text" id="email" className="form-control" required ref={emailRef} defaultValue={employee?.email}></input>
        </div>
        <div>
            <label htmlFor="role" className={styles.label}>Role :</label>
            <input type="text" id="role" className="form-control" required ref={roleRef} defaultValue={employee?.role}></input>
        </div>

        <div className={styles.buttoncontainer}>
            <button className={styles.okbutton }>OK</button>
            <button className={styles.cancelbutton} onClick={() => navigate('/ListEmployeePage')}>Annuler</button>
        </div>

    </form>

    </>



    )
}

export default AddEmployeeForm