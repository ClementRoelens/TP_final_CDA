import React from 'react'
import styles from "../../style/ListActions.module.css";

function ListActions() {
  return (
    <div className={styles.actionsContainer}>
        <button>Créer rapport</button>
        <button>Modifier</button>
        <button>Supprimer</button>
    </div>
  )
}

export default ListActions