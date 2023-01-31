import React from 'react'
import styles from './Separator.module.css'

export default function Separator({...props}) {
  return (
    <hr className={styles.hr} {...props}/>
  )
}
