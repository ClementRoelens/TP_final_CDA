import { useDispatch, useSelector } from "react-redux";
import Header from "../components/shared/Header"
import ListActions from "../components/shared/ListActions"
import styles from "../style/ListEmployes.module.css";
import { useEffect } from "react";
import { fetchEmployeesAction } from "./employeeSlice";

const ListEmployeePage = () => {
    const employees = useSelector(state => state.employees.employees);
    const dispatch = useDispatch();

    useEffect(() => {
        dispatch(fetchEmployeesAction());
    }, []);

    return (
        <>
            <Header />
            <div className={styles.container}>
                <div className={styles.actions}>
                    <input type="text" />
                    <button>Filtrer</button>
                    <button>Trier</button>
                </div>
                <table className={styles.table}>
                    <thead>
                        <tr className={styles.thead}>
                            <th className={styles.thead}></th>
                            <th className={styles.thead}>Nom</th>
                            <th className={styles.thead}>Prénom</th>
                            <th className={styles.thead}>Présence</th>
                            <th className={styles.thead}>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        {employees.map((employee, index) => 
                            <tr key={employee.id}>
                                <td>{index}</td>
                                <td>{employee.lastName}</td>
                                <td>{employee.firstName}</td>
                                <td>{employee.isPresent ? "PRÉSENT" : "ABSENT"}</td>
                                <td><ListActions /></td>
                            </tr>
                        )}
                    </tbody>
                </table>
                <button className={styles.add}>Ajouter</button>
            </div>
        </>
    )
}
export default ListEmployeePage