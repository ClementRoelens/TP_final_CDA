import { useDispatch, useSelector } from "react-redux"
import classes from "../../style/Modal.module.css"
import { useNavigate } from "react-router-dom"

const Modal = (props) => {
    const dispatch = useDispatch()
    const navigate = useNavigate()
    const selectedEmployee = useSelector(state => state.employees.selectedEmployee)
    const token = localStorage.getItem("token")

    const handleBackgroundClick = () => {
        //peut etre mettre modal hidden au clique sur la croix et faire apparaitre la modal au clique sur delete
    }

    const handleValidateClick = () => {
        dispatch(deleteEmployeeAction(selectedEmployee))
    }

    return ( 
        <div className={classes.modal}>
            <div className={classes.modalContent}>
                <button onClick={handleBackgroundClick} className="btn btn-danger">X</button>
                <button onClick={handleValidateClick}>Valider</button>
            </div>
        </div>
     );
}
 
export default Modal;