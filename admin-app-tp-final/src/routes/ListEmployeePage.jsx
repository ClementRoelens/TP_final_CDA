import Header from "../components/shared/Header"
import ListActions from "../components/shared/ListActions"
import styles from"../style/ListEmployes.module.css";

const ListEmployeePage = () => {

    return (
        <>
        <Header />
        <div className="container">
            <div className={styles.actions}>
                <input type="text" />
                <button>Filtrer</button>
                <button>Trier</button>
            </div>
            <table>
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Nom</th>
                        <th>Prénom</th>
                        <th>Présence</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1</td>
                        <td>Roelens</td>
                        <td>Clément</td>
                        <td>PRÉSENT</td>
                        <td><ListActions/></td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>Sahkri</td>
                        <td>Nassim</td>
                        <td>ABSENT</td>
                        <td><ListActions/></td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td>Laout</td>
                        <td>Pauline</td>
                        <td>PRÉSENT</td>
                        <td><ListActions/></td>
                    </tr>
                </tbody>
            </table>
            <button>Ajouter</button>
        </div>
        </>
    )
}
export default ListEmployeePage