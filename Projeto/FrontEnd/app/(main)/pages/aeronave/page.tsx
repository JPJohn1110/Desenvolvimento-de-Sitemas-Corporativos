/* eslint-disable @next/next/no-img-element */
'use client';
import { Button } from 'primereact/button';
import { Column } from 'primereact/column';
import { DataTable } from 'primereact/datatable';
import { Dialog } from 'primereact/dialog';
import { FileUpload } from 'primereact/fileupload';
import { InputNumber, InputNumberValueChangeEvent } from 'primereact/inputnumber';
import { InputText } from 'primereact/inputtext';
import { InputTextarea } from 'primereact/inputtextarea';
import { RadioButton, RadioButtonChangeEvent } from 'primereact/radiobutton';
import { Rating } from 'primereact/rating';
import { Toast } from 'primereact/toast';
import { Toolbar } from 'primereact/toolbar';
import { classNames } from 'primereact/utils';
import React, { useEffect, useRef, useState } from 'react';
import { ProductService } from '../../../../demo/service/ProductService';
import { Companhia } from '@/types';

/* @todo Used 'as any' for types here. Will fix in next version due to onSelectionChange event type issue. */
const Crud = () => {
    let aeronaveVazio: Companhia.Aeronave = {
        id: 0,
        modelo: '',
        capacidade: 0,
    };

    const [aeronaves, setAeronaves] = useState(null);
    const [aeronaveDialog, setAeronaveDialog] = useState(false);
    const [deleteAeronaveDialog, setDeleteAeronaveDialog] = useState(false);
    const [deleteAeronavesDialog, setDeleteAeronavesDialog] = useState(false);
    const [aeronave, setAeronave] = useState<Companhia.Aeronave>(aeronaveVazio);
    const [selectedAeronaves, setSelectedAeronaves] = useState(null);
    const [submitted, setSubmitted] = useState(false);
    const [globalFilter, setGlobalFilter] = useState('');
    const toast = useRef<Toast>(null);
    const dt = useRef<DataTable<any>>(null);

    useEffect(() => {
        //ProductService.getProducts().then((data) => setProducts(data as any));
    }, []);

    const openNew = () => {
        setAeronave(aeronaveVazio);
        setSubmitted(false);
        setAeronaveDialog(true);
    };

    const hideDialog = () => {
        setSubmitted(false);
        setAeronaveDialog(false);
    };

    const hideDeleteAeronaveDialog = () => {
        setDeleteAeronaveDialog(false);
    };

    const hideDeleteAeronavesDialog = () => {
        setDeleteAeronavesDialog(false);
    };

    const saveAeronave = () => {
        setSubmitted(true);

        /*
        if (product.name.trim()) {
            let _products = [...(products as any)];
            let _product = { ...product };
            if (product.id) {
                const index = findIndexById(product.id);

                _products[index] = _product;
                toast.current?.show({
                    severity: 'success',
                    summary: 'Successful',
                    detail: 'Product Updated',
                    life: 3000
                });
            } else {
                _product.id = createId();
                _product.image = 'product-placeholder.svg';
                _products.push(_product);
                toast.current?.show({
                    severity: 'success',
                    summary: 'Successful',
                    detail: 'Product Created',
                    life: 3000
                });
            }

            setProducts(_products as any);
            setProductDialog(false);
            setProduct(emptyProduct);
        } */
    };

    const editAeronave = (aeronave: Companhia.Aeronave) => {
        setAeronave({ ...aeronave });
        setAeronaveDialog(true);
    };

    const confirmDeleteAeronave = (aeronave: Companhia.Aeronave) => {
        setAeronave(aeronave);
        setDeleteAeronaveDialog(true);
    };

    const deleteAeronave = () => {
        /*let _products = (products as any)?.filter((val: any) => val.id !== product.id);
        setProducts(_products);
        setDeleteProductDialog(false);
        setProduct(emptyProduct);
        toast.current?.show({
            severity: 'success',
            summary: 'Successful',
            detail: 'Product Deleted',
            life: 3000
        });*/
    };

    /*const findIndexById = (id: string) => {
        let index = -1;
        for (let i = 0; i < (products as any)?.length; i++) {
            if ((products as any)[i].id === id) {
                index = i;
                break;
            }
        }

        return index;
    };*/

    /*const createId = () => {
        let id = '';
        let chars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
        for (let i = 0; i < 5; i++) {
            id += chars.charAt(Math.floor(Math.random() * chars.length));
        }
        return id;
    };*/

    const exportCSV = () => {
        dt.current?.exportCSV();
    };

    const confirmDeleteSelected = () => {
        setDeleteAeronavesDialog(true);
    };

    const deleteSelectedAeronaves = () => {
        /*let _products = (products as any)?.filter((val: any) => !(selectedProducts as any)?.includes(val));
        setProducts(_products);
        setDeleteProductsDialog(false);
        setSelectedProducts(null);
        toast.current?.show({
            severity: 'success',
            summary: 'Successful',
            detail: 'Products Deleted',
            life: 3000
        });*/
    };

    /*const onCategoryChange = (e: RadioButtonChangeEvent) => {
        let _product = { ...product };
        _product['category'] = e.value;
        setProduct(_product);
    };*/

    const onInputChange = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>, campo: 'modelo' | 'capacidade') => {
        const val = e.target.value;
        let _aeronave = { ...aeronave };
    
        if (campo === 'modelo') {
            _aeronave.modelo = val;
        } else if (campo === 'capacidade') {
            _aeronave.capacidade = parseInt(val) || 0;  // Certifica-se de que a capacidade seja um número
        }
    
        setAeronave(_aeronave);
    };
    

    /*const onInputNumberChange = (e: InputNumberValueChangeEvent, name: string) => {
        const val = e.value || 0;
        let _product = { ...product };
        _product[`${name}`] = val;

        setProduct(_product);
    };*/

    const leftToolbarTemplate = () => {
        return (
            <React.Fragment>
                <div className="my-2">
                    <Button label="Novo" icon="pi pi-plus" severity="success" className=" mr-2" onClick={openNew} />
                    <Button label="Excluir" icon="pi pi-trash" severity="danger" onClick={confirmDeleteSelected} disabled={!selectedAeronaves || !(selectedAeronaves as any).length} />
                </div>
            </React.Fragment>
        );
    };

    const rightToolbarTemplate = () => {
        return (
            <React.Fragment>
                <FileUpload mode="basic" accept="image/*" maxFileSize={1000000} chooseLabel="Import" className="mr-2 inline-block" />
                <Button label="Export" icon="pi pi-upload" severity="help" onClick={exportCSV} />
            </React.Fragment>
        );
    };

    const idBodyTemplate = (rowData: Companhia.Aeronave) => {
        return (
            <>
                <span className="p-column-title">Código</span>
                {rowData.id}
            </>
        );
    };

    const modeloBodyTemplate = (rowData: Companhia.Aeronave) => {
        return (
            <>
                <span className="p-column-title">Modelo</span>
                {rowData.modelo}
            </>
        );
    };

    const capacidadeBodyTemplate = (rowData: Companhia.Aeronave) => {
        return (
            <>
                <span className="p-column-title">Capacidade</span>
                {rowData.capacidade}
            </>
        );
    };

    const actionBodyTemplate = (rowData: Companhia.Aeronave) => {
        return (
            <>
                <Button icon="pi pi-pencil" rounded severity="success" className="mr-2" onClick={() => editAeronave(rowData)} />
                <Button icon="pi pi-trash" rounded severity="warning" onClick={() => confirmDeleteAeronave(rowData)} />
            </>
        );
    };

    const header = (
        <div className="flex flex-column md:flex-row md:justify-content-between md:align-items-center">
            <h5 className="m-0">Gereciamento de Aeronaves</h5>
            <span className="block mt-2 md:mt-0 p-input-icon-left">
                <i className="pi pi-search" />
                <InputText type="search" onInput={(e) => setGlobalFilter(e.currentTarget.value)} placeholder="Search..." />
            </span>
        </div>
    );

    const aeronaveDialogFooter = (
        <>
            <Button label="Cancelar" icon="pi pi-times" text onClick={hideDialog} />
            <Button label="Salvar" icon="pi pi-check" text onClick={saveAeronave} />
        </>
    );
    const deleteAeronaveDialogFooter = (
        <>
            <Button label="Não" icon="pi pi-times" text onClick={hideDeleteAeronaveDialog} />
            <Button label="Sim" icon="pi pi-check" text onClick={deleteAeronave} />
        </>
    );
    const deleteAeronavesDialogFooter = (
        <>
            <Button label="Não" icon="pi pi-times" text onClick={hideDeleteAeronavesDialog} />
            <Button label="Sim" icon="pi pi-check" text onClick={deleteSelectedAeronaves} />
        </>
    );

    return (
        <div className="grid crud-demo">
            <div className="col-12">
                <div className="card">
                    <Toast ref={toast} />
                    <Toolbar className="mb-4" left={leftToolbarTemplate} right={rightToolbarTemplate}></Toolbar>

                    <DataTable
                        ref={dt}
                        value={aeronaves}
                        selection={selectedAeronaves}
                        onSelectionChange={(e) => setSelectedAeronaves(e.value as any)}
                        dataKey="id"
                        paginator
                        rows={10}
                        rowsPerPageOptions={[5, 10, 25]}
                        className="datatable-responsive"
                        paginatorTemplate="FirstPageLink PrevPageLink PageLinks NextPageLink LastPageLink CurrentPageReport RowsPerPageDropdown"
                        currentPageReportTemplate="Mostrando {first} até {last} de {totalRecords} aeronaves"
                        globalFilter={globalFilter}
                        emptyMessage="Nenhuma aeronave encontrada."
                        header={header}
                        responsiveLayout="scroll"
                    >
                        <Column selectionMode="multiple" headerStyle={{ width: '4rem' }}></Column>
                        <Column field="id" header="Código" sortable body={idBodyTemplate} headerStyle={{ minWidth: '15rem' }}></Column>
                        <Column field="modelo" header="Modelo" sortable body={modeloBodyTemplate} headerStyle={{ minWidth: '15rem' }}></Column>
                        <Column field="capacidade" header="Capacidade" sortable body={capacidadeBodyTemplate} headerStyle={{ minWidth: '15rem' }}></Column>
                        <Column body={actionBodyTemplate} headerStyle={{ minWidth: '10rem' }}></Column>
                    </DataTable>

                    <Dialog visible={aeronaveDialog} style={{ width: '450px' }} header="Detalhes da Aeronave" modal className="p-fluid" footer={aeronaveDialogFooter} onHide={hideDialog}>
                        <div className="field">
                            <label htmlFor="modelo">Modelo</label>
                            <InputText
                                id="modelo"
                                value={aeronave.modelo}
                                onChange={(e) => onInputChange(e, 'modelo')}
                                required
                                autoFocus
                                className={classNames({
                                    'p-invalid': submitted && !aeronave.modelo
                                })}
                            />
                            {submitted && !aeronave.modelo && <small className="p-invalid">Modelo é obrigatório.</small>}
                        </div>
                        <div className="field">
                            <label htmlFor="capacidade">Capacidade</label>
                            <InputText
                                id="capacidade"
                                value={aeronave.capacidade?.toString() || ''}
                                onChange={(e) => onInputChange(e, 'capacidade')}
                                required
                                autoFocus
                                className={classNames({
                                    'p-invalid': submitted && !aeronave.capacidade
                                })}
                            />
                            {submitted && !aeronave.capacidade && (
                                <small className="p-invalid">Capacidade é obrigatório.</small>
                            )}
                        </div>
                    </Dialog>

                    <Dialog visible={deleteAeronaveDialog} style={{ width: '450px' }} header="Confirm" modal footer={deleteAeronaveDialogFooter} onHide={hideDeleteAeronaveDialog}>
                        <div className="flex align-items-center justify-content-center">
                            <i className="pi pi-exclamation-triangle mr-3" style={{ fontSize: '2rem' }} />
                            {aeronave && (
                                <span>
                                    Você realmente deseja excluir a aeronave? <b>{aeronave.modelo}</b>?
                                </span>
                            )}
                        </div>
                    </Dialog>

                    <Dialog visible={deleteAeronavesDialog} style={{ width: '450px' }} header="Confirm" modal footer={deleteAeronavesDialogFooter} onHide={hideDeleteAeronavesDialog}>
                        <div className="flex align-items-center justify-content-center">
                            <i className="pi pi-exclamation-triangle mr-3" style={{ fontSize: '2rem' }} />
                            {aeronave && <span>Você realmente deseja excluir as aeronaves selocionados?</span>}
                        </div>
                    </Dialog>
                </div>
            </div>
        </div>
    );
};

export default Crud;
