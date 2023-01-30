import { useState } from 'react'
import './CompanyCard.css'
import axios from 'axios'


export default function CompanyCard() {



    const [empresas, setEmpresas] = useState(array)

    // utilizando o auxios para se conetar com a API
    useEffect(() => {
        axios.get("").then(result => {
            console.log()
            setEmpresas(result.data)
        })
    }, [])

    return (
        <div className='d-flex justify-content-center'>
            <div className='d-flex flex-row mb-3 justify-content-center align-self-center flex-wrap' >
                {empresas.map((empresa) =>

                    <div key={empresa.id} className='Card card-backgound' width={'18rem'}  >
                        <a href="" className='link'>
                            <div className="card-body" >
                                <img className='img-card' src={empresa.img} alt="logo da empresa" width={'200px'}></img>
                                <h5 className="card-title">{empresa.nome}</h5>
                                {/* <p className="card-text" >{empresa.descricao}</p> */}
                            </div>
                        </a>
                    </div>

                )
                }
            </div>


        </div>
    )
}