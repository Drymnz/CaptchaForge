import { Routes } from '@angular/router';
import CaptchaGeneratorComponent from './components/captcha-generator/captcha-generator.component';
import { CaptchaUsageReportComponent } from './components/captcha-usage-report/captcha-usage-report.component';
import { SymbolTableComponent } from './components/symbol-table/symbol-table.component';
import { CaptchaListComponent } from './components/captcha-list/captcha-list.component';
import { ErrorListingComponent } from './components/error-listing/error-listing.component';
import { TableExecutionComponent } from './components/table-execution/table-execution.component';

export const routes: Routes = [
    {
        path: 'generar',
        title:'Generador de Captcha',
        component:CaptchaGeneratorComponent
    },
    {
        path: 'list-error',
        title:'Listado de Errores',
        component:ErrorListingComponent
    },
    {
        path: 'reporte-captcha',
        title:'Reportes de captcha utilizados',
        component:CaptchaUsageReportComponent
    },
    {
        path: 'tabla-simbolos',
        title:'Tabla de simbolos',
        component:SymbolTableComponent
    },
    { 
        path: '8',
        component: TableExecutionComponent 

    },
    {
        path: 'list-chaptcha',
        title:'Listado de Captcha',
        component:CaptchaListComponent
    },
    {
        path: '**',
        redirectTo:'generar',
        pathMatch: 'full'
    },
    {
        path: '',
        redirectTo:'generar',
        pathMatch: 'full'
    }
];
