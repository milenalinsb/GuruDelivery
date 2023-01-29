import React from 'react'
import styles from './LargeButton.module.css'

export default function LargeButton({text, action, bg, ...props}) {
  return (
    <button className={styles.largeButton} type='submit' style={!bg?{
        backgroundColor: 'var(--surfice)',
        color: 'var(--primary)',
        border: '1px solid'
        }:{}}
        {...props}
    >
        {text}
    </button>
  )
}
