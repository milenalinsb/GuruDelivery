import React from 'react'
import { Field, Form, Formik } from 'formik'
import { useNavigate } from 'react-router-dom'
import InputText from '../../components/InputText'
import LargeButton from '../../components/LargeButton'
import Separator from '../../components/Separator'
import { postProduto } from '../../api/empresa'

export default function NewProdPage() {
  const navigate = useNavigate();

  const initial = {
    nome: "",
    foto: "",
    preco: "",
    descricao: ""
  }

  async function onSubmit(values, {resetForm}){
    const produto = {
            "nome": values.nome,
            "foto": "",
            "preco": values.preco,
            "descricao": values.descricao
    }
    try{
        const response = await postProduto(produto)
        alert(response)
        resetForm()
        navigate("/meusprodutos")
    }catch(error){
        console.error(error)
    }
  }

  return (

    <>
      <div className='h-screen flex flex-col items-center center
          justify-center bg-background font-sans'>
          <div className='w-full bg-surface drop-shadow p-5 rounded-lg max-w-md'>
            <div className='text-primary text-4xl text-center my-8'>
              Guru Delivery
            </div>
            <div className='text-center text-md font-sans'>
              Cadastre um novo produto.
            </div>
            <Separator />

            <div className='flex flex-col'>
              <Formik 
                initialValues={initial}
                onSubmit={onSubmit}
              >
              {() => (
                <Form className='flex flex-col'>
                  <Field name="foto" type="file"/>
                  <Field as={InputText} name="nome" type="text" placeholder="Digite o nome"/>
                  <Field component='textarea' name="descricao" placeholder="Descrição"/>
                  <Field as={InputText} name="preco" type="number" placeholder="Preço"/>
                  <div className='flex flex-col mt-10'>
                    <LargeButton text="Enviar" bg/>
                  </div>
                </Form>
            )}
            </Formik>
          </div>

        </div>
      </div>
    </>
  )
}
