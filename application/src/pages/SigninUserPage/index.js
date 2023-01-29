import React from 'react'
import styles from './SigninUserPage.module.css'
import loginStyles from '../LoginPage/LoginPage.module.css'
import Separator from '../../components/Separator'
import InputText from '../../components/InputText'
import LargeButton from '../../components/LargeButton'

export default function SigninUserPage() {
  return (
    <div className='container'>
        <div className={styles.signinContainer}>

            <div className={loginStyles.header}>
                <div className={loginStyles.headerLogo}>
                    Guru Delivery
                </div>
                <div className={loginStyles.headerText}>
                    Preencha os campos para criar o seu cadastro.
                </div>
                <Separator/>
            </div>
            <div className={loginStyles.form}>
                <form>
                    <InputText type="text" placeholder="Digite seu nome"/>
                    <InputText type="email" placeholder="Digite seu e-mail"/>
                    <InputText type="password" placeholder="Digite sua senha"/>
                    <LargeButton text="Cadastrar" bg/>
                    <Separator/>
                </form>
            </div>
            <div className={styles.footer}>
                Já tem cadastro? <a href='#'>Fazer Login</a>
            </div>

        </div>
    </div>
  )
}
