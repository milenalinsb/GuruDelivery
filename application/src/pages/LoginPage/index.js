import React from 'react'
import InputText from '../../components/InputText'
import LargeButton from '../../components/LargeButton'
import Separator from '../../components/Separator'
import style from './LoginPage.module.css'

export default function Login() {
  return (
    <>
      <div className='container' >
        <div className={style.loginContainer}>

          <div className={style.header}>
            <div className={style.headerLogo}>
              Guru Delivery
            </div>
            <div className={style.headerText}>
              Use suas credenciais para realizar o login.
            </div>
            <Separator />
          </div>

          <div className={style.form}>
            <form>
              <InputText type="email" placeholder="Digite o seu email"/>
              <InputText type="password" placeholder='Digite sua senha'/>
              <LargeButton text="Enviar" bg/>
              <Separator />
            </form>
          </div>

          <div className={style.footer}>
            <LargeButton text="Quero me Cadastrar"/>
          </div>
        </div>
      </div>
    </>
  )
}
