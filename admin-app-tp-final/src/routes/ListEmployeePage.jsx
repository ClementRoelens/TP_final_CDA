import Header from "../components/shared/Header"
import ListActions from "../components/shared/ListActions"
import styles from"../style/ListEmployes.module.css";

const ListEmployeePage = () => {

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
            <button className={styles.add}>Ajouter</button>
        </div>
        </>
    )
}
export default ListEmployeePage